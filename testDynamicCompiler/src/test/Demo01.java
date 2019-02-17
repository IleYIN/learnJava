package test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Build Path要换成用jdk开发，不能用jre
 */
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {

	public static void main(String[] args) throws IOException {
		
		
		String str = "public class HelloWorld{\r\n" + 
				"	public static void main(String[] args){\r\n" + 
				"		System.out.println(\"Hi,world!\");\r\n" + 
				"	}\r\n" + 
				"}";
		//TODO 通过IO流操作，将字符串存储成一个临时文件（Hi.java），然后调用动态编译方法
		
		//通过JavaCompiler
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null,null,null,"D:/informatique/HelloWorld.java");
		System.out.println(result==0?"编译成功":"编译失败");
		
		
		//通过Runtime.getRuntime()运行启动新的进程运行
//		Runtime run = Runtime.getRuntime();
//		Process process = run.exec("java -cp D:/informatique HelloWorld");
//		
//		InputStream in = process.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		String info = "";
//		while((info=reader.readLine())!=null) {
//			System.out.println(info);
//		}
		
		
		//通过反射运行
		try {
			
			URL[] urls = new URL[] {new URL("file:/"+"D:/informatique/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("HelloWorld");
			
			//调用加载类的main方法
			Method m;
			m = c.getMethod("main",String[].class);
			
			//静态方法，可以不用传对象所以是null，后面那个是参数
			//public static void mm(String[] a, String[] b)则写成m.invoke(null, (Object)new String[]{}, (Object)new String[]{});
			m.invoke(null, (Object)new String[]{});//public static void main(String[] a)
			//必须要写Object转型，否则m.invoke(null, new String[]{"aa","bb"})会变成m.invoke(null,"aa","bb")多个参数，和原来参数个数不匹配
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
