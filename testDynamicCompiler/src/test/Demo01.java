package test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Build PathҪ������jdk������������jre
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
		//TODO ͨ��IO�����������ַ����洢��һ����ʱ�ļ���Hi.java����Ȼ����ö�̬���뷽��
		
		//ͨ��JavaCompiler
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null,null,null,"D:/informatique/HelloWorld.java");
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		
		
		//ͨ��Runtime.getRuntime()���������µĽ�������
//		Runtime run = Runtime.getRuntime();
//		Process process = run.exec("java -cp D:/informatique HelloWorld");
//		
//		InputStream in = process.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		String info = "";
//		while((info=reader.readLine())!=null) {
//			System.out.println(info);
//		}
		
		
		//ͨ����������
		try {
			
			URL[] urls = new URL[] {new URL("file:/"+"D:/informatique/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("HelloWorld");
			
			//���ü������main����
			Method m;
			m = c.getMethod("main",String[].class);
			
			//��̬���������Բ��ô�����������null�������Ǹ��ǲ���
			//public static void mm(String[] a, String[] b)��д��m.invoke(null, (Object)new String[]{}, (Object)new String[]{});
			m.invoke(null, (Object)new String[]{});//public static void main(String[] a)
			//����ҪдObjectת�ͣ�����m.invoke(null, new String[]{"aa","bb"})����m.invoke(null,"aa","bb")�����������ԭ������������ƥ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
