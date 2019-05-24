package testClassLoader;

public class Demo02 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		//application classloader
		
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		//extensions classloader
		
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		//bootstrap classloader  JAVA_HOME/jre/lib/rt.jar 其中有java.lang.String
		
		
		System.out.println(System.getProperty("java.class.path"));
		
		System.out.println("------------");
		String a = "gaogao";
		System.out.println(a.getClass().getClassLoader());
		//调用的是父类的父类的java.lang.String 而不是自己创建的那个类
		//这样就避免发生安全问题，保证用户永远定义不出java.lang.Object类
		System.out.println(a);
	}
}
