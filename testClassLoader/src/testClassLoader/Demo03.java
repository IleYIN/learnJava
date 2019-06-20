package testClassLoader;
/**
 * test the self defined FileSystemClassLoader
 * 
 * @author y.yin
 *
 */
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("D:/y.yin/JavaWS");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("D:/y.yin/JavaWS");
		
//		Class<?> c = loader.loadClass("myPackage.HelloWorld");
//		Class<?> c2 = loader.loadClass("myPackage.HelloWorld");
//		Class<?> c3 = loader2.loadClass("myPackage.HelloWorld");
		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader2.loadClass("testClassLoader.Demo01");
		
//		System.out.println(c);
//		System.out.println(c.hashCode());
//		System.out.println(c2.hashCode());
//		System.out.println(c2.getClassLoader());
//		
//		System.out.println(c3.hashCode());//same classLoader for same class->same class object; different classLoader for same class-> different object
//		System.out.println(c3.getClassLoader());//it uses self defined class loader
		
		System.out.println(c4.hashCode());
		System.out.println(c4.getClassLoader());//null because it uses bootstrap引导类加载器
		System.out.println(c5.getClassLoader());//default class loader
	}
	
}
