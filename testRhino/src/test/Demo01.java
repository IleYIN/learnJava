package test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo01 {

	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		//获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变量,存储到引擎上下文中
		engine.put("msg", "he's good");
		String str = "var user = {name:'xiaohong', age:18, schools:['nankai','tsinghua']};";
		
		str += "print(user.name);";//变量被脚本jsp操作
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg = 'she is good';");//变量被java操作
		
		System.out.println(engine.get("msg"));
		System.out.println("##############");
	
		//定义函数
		engine.eval("function add(a,b){var sum = a + b; return sum;}");
		
		//取得调用接口
		Invocable jsInvoke = (Invocable) engine;
		
		//执行脚本中定义的函数方法
		Object result1 = jsInvoke.invokeFunction("add", new Object[] {13,20});
		System.out.println(result1);
		
		//导入其他java包，使用其他包中的java类，若需要深入了解细节，可以详细学习Rhino的语法
		//jdk1.6使用的方法规则1.8已经不适用了  String jsCode = "importPackage(java.util); var list = Arrays.asList([\"北京大学\",\"清华大学\",\"南开大学\"])";
		String jsCode = "var list = java.util.Arrays.asList([\"北京尚学堂\",\"清华大学\",\"北京大学\"]);";
		engine.eval(jsCode);
		
		List<String> list2 = (List<String>)engine.get("list");
		for(String temp : list2) {
			System.out.println(temp);
		}
		
		//执行一个js文件（将a.js置于项目的src下即可）
		URL url = Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();//实际时要用try catch finally！更规范
		
		
		
	}
}
