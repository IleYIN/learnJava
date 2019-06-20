package testClassLoader;

/**
 * Self-defined ClassLoader->App->External ClassLoader->bootstrap(引导) ClassLoader
 * 
 * Parent classLoader will be used in priority 双亲委托机制
 * 
 * @author y.yin
 *
 */

public class Demo01 {
	
	static {
		System.out.println("静态初始化Demo01");
		//main方法所在类会被初始化
	}

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Demo01的main方法！");
	
		/*A a = new A();
		System.out.println(A.width);
		
		//类加载初始化只进行一次
		A a2 = new A();*/
		
		//主动引用
//		new A();//new一个类会初始化（类的主动引用）
//		System.out.println(A.width);//调用A的静态量会初始化
		Class.forName("testClassLoader.A");//反射调用也会初始化

		
		//被动引用
		//System.out.println(A.MAX);//调用A的常量不会初始化（类的被动引用）
		//常量在编译阶段就存入调用类的常量池中
		//A[] as = new A[10];//通过数组定义类引用，不会初始化
		System.out.println(B.width);//B没有初始化，因为访问的是父类的静态量
	}
}

class A extends A_Father {
	//先初始化父类
	public static int width = 100;
	public static final int MAX = 200;
	static {
		System.out.println("静态初始化类A");
		width = 300;
	}
	public A() {
		System.out.println("创建A类的对象");
	}
}

class B extends A{
	static {
		System.out.println("静态初始化B");
	}
}

class A_Father /*extends Object*/ {
	static {
		System.out.println("静态初始化A_Father");
	}
}
