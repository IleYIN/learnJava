package testClassLoader;
/**
 * 线程上下文类加载器 抛弃了双亲委托机制
 * @author y.yin
 *
 *
 * TOMCAT
 * OSGi(Open Service Gateway Initative) 谁定义的由谁加载  Equinox OSGi的一个实现
 */


public class Demo05 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = Demo05.class.getClassLoader();
		System.out.println(loader);// app classLoader by default
		
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);// app classLoader by default
		
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("D:/y.yin/JavaWS"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		Class<Demo01> c = (Class<Demo01>) Thread.currentThread().getContextClassLoader().loadClass("testClassLoader.Demo01");
		System.out.println(c);
		System.out.println(c.getClassLoader());//app classLoader, because we define 双亲委托机制 in FileSystemClassLoader, we can change it.
	}
}

