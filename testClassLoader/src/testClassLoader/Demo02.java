package testClassLoader;

public class Demo02 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		//application classloader
		
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		//extensions classloader
		
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		//bootstrap classloader  JAVA_HOME/jre/lib/rt.jar ������java.lang.String
		
		
		System.out.println(System.getProperty("java.class.path"));
		
		System.out.println("------------");
		String a = "gaogao";
		System.out.println(a.getClass().getClassLoader());
		//���õ��Ǹ���ĸ����java.lang.String �������Լ��������Ǹ���
		//�����ͱ��ⷢ����ȫ���⣬��֤�û���Զ���岻��java.lang.Object��
		System.out.println(a);
	}
}
