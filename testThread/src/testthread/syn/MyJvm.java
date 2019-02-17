package testthread.syn;
/**
 * 单例创建的方式
 * 
 * @author yinyiliang
 *
 */

/*
 * 懒汉式 double checking-->if(null==instance)
 * 1、构造器私有化，避免外部直接创建对象
 * 2、声明一个私有的静态变量
 * 3、创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
 */
public class MyJvm {

	private static MyJvm instance;
	private MyJvm(){
		
	}
	
	public static MyJvm getInstance(){
		if(null==instance){//提高效率
			synchronized(MyJvm.class){
				if(null==instance){//安全
					instance = new MyJvm();
				}
				
			}
		}
		return instance;
	}
}



/*
 * 饿汉式
 * 1、构造器私有化，避免外部直接创建对象
 * 2、声明一个私有的静态变量,同时创建该对象
 * 3、创建一个对外的公共的静态方法 访问该变量或属性
 */
/**
 * 类里面的属性一定会随着类的加载而初始化，但是类中的方法只有在被调用时才会加载
 * @author yinyiliang
 *
 */
class MyJvm2 {

	private static MyJvm2 instance = new MyJvm2();
	private MyJvm2(){
		
	}
	
	public static MyJvm2 getInstance(){
		return instance;
	}
}
/**
 * 类在使用时才会加载，如果使用MyJvm3但不调用getInstance方法的话，内部类不会加载
 * 因此减少了加载时间
 * 
 * @author yinyiliang
 *
 */
class MyJvm3 {

	private static class JVMholder{//一个内部类属性
		
		private static MyJvm3 instance = new MyJvm3();
	}
	private MyJvm3(){
		
	}
	
	public static MyJvm3 getInstance(){
		return JVMholder.instance;
	}
}