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
		//��ýű��������
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//�������,�洢��������������
		engine.put("msg", "he's good");
		String str = "var user = {name:'xiaohong', age:18, schools:['nankai','tsinghua']};";
		
		str += "print(user.name);";//�������ű�jsp����
		
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg = 'she is good';");//������java����
		
		System.out.println(engine.get("msg"));
		System.out.println("##############");
	
		//���庯��
		engine.eval("function add(a,b){var sum = a + b; return sum;}");
		
		//ȡ�õ��ýӿ�
		Invocable jsInvoke = (Invocable) engine;
		
		//ִ�нű��ж���ĺ�������
		Object result1 = jsInvoke.invokeFunction("add", new Object[] {13,20});
		System.out.println(result1);
		
		//��������java����ʹ���������е�java�࣬����Ҫ�����˽�ϸ�ڣ�������ϸѧϰRhino���﷨
		//jdk1.6ʹ�õķ�������1.8�Ѿ���������  String jsCode = "importPackage(java.util); var list = Arrays.asList([\"������ѧ\",\"�廪��ѧ\",\"�Ͽ���ѧ\"])";
		String jsCode = "var list = java.util.Arrays.asList([\"������ѧ��\",\"�廪��ѧ\",\"������ѧ\"]);";
		engine.eval(jsCode);
		
		List<String> list2 = (List<String>)engine.get("list");
		for(String temp : list2) {
			System.out.println(temp);
		}
		
		//ִ��һ��js�ļ�����a.js������Ŀ��src�¼��ɣ�
		URL url = Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();//ʵ��ʱҪ��try catch finally�����淶
		
		
		
	}
}
