package testClassLoader;
/**
 * �߳�������������� ������˫��ί�л���
 * @author y.yin
 *
 *
 * TOMCAT
 * OSGi(Open Service Gateway Initative) ˭�������˭����  Equinox OSGi��һ��ʵ��
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
		System.out.println(c.getClassLoader());//app classLoader, because we define ˫��ί�л��� in FileSystemClassLoader, we can change it.
	}
}

