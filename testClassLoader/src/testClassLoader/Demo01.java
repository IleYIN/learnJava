package testClassLoader;

/**
 * Self-defined ClassLoader->App->External ClassLoader->bootstrap(����) ClassLoader
 * 
 * Parent classLoader will be used in priority ˫��ί�л���
 * 
 * @author y.yin
 *
 */

public class Demo01 {
	
	static {
		System.out.println("��̬��ʼ��Demo01");
		//main����������ᱻ��ʼ��
	}

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Demo01��main������");
	
		/*A a = new A();
		System.out.println(A.width);
		
		//����س�ʼ��ֻ����һ��
		A a2 = new A();*/
		
		//��������
//		new A();//newһ������ʼ��������������ã�
//		System.out.println(A.width);//����A�ľ�̬�����ʼ��
		Class.forName("testClassLoader.A");//�������Ҳ���ʼ��

		
		//��������
		//System.out.println(A.MAX);//����A�ĳ��������ʼ������ı������ã�
		//�����ڱ���׶ξʹ��������ĳ�������
		//A[] as = new A[10];//ͨ�����鶨�������ã������ʼ��
		System.out.println(B.width);//Bû�г�ʼ������Ϊ���ʵ��Ǹ���ľ�̬��
	}
}

class A extends A_Father {
	//�ȳ�ʼ������
	public static int width = 100;
	public static final int MAX = 200;
	static {
		System.out.println("��̬��ʼ����A");
		width = 300;
	}
	public A() {
		System.out.println("����A��Ķ���");
	}
}

class B extends A{
	static {
		System.out.println("��̬��ʼ��B");
	}
}

class A_Father /*extends Object*/ {
	static {
		System.out.println("��̬��ʼ��A_Father");
	}
}
