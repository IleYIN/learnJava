package testthread.create;
/**
 * 使用Runnable创建线程 好处：避免单继承的局限性;方便共享资源
 * 
 * 
 * extends与implements的区别： 
 * extends 是继承父类，只要那个类不是声明为final或者那个类定义为abstract的就能继承，
 * JAVA中不支持多重继承，但是可以用接口来实现，这样就用到了implements，继承只能继承一个类，
 * 但implements可以实现多个接口，用逗号分开就行了。
 * 
 * 1、类 实现Runnable接口 + 重写run()线程体 --> 真实角色类
 * 2、启动多线程 使用静态代理
 *   创建真实角色 创建代理角色+真实角色引用  调用.start()启动线程
 * 
 * @author yinyiliang
 *
 */
public class Programmer implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<1000;i++){
			System.out.println("敲代码");
		}
	}

	
}
