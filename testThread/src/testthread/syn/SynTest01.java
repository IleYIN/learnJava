package testthread.syn;


/**
 * synchronized 锁 线程安全
 * synchronized(引用类型|this|类.class)
 * 
 * https://blog.csdn.net/xiao__gui/article/details/8188833
 * https://www.jianshu.com/p/7ef502580df3
 * 
 * 
 * 
 * @author yinyiliang
 *
 */
public class SynTest01 {


	public static void main(String[] args) {
		
		//真实角色
		Web12306 web = new Web12306();
		
		//代理
		Thread t1 = new Thread(web,"代理票务1");
		Thread t2 = new Thread(web,"代理票务2");
		Thread t3 = new Thread(web,"代理票务3");
		
		//启动线程
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}

class Web12306 implements Runnable {

	private int num = 10;

	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag){
			test4();
		}
	}
	
	
	//线程不安全 锁定资源不正确（并没有锁定num 数字还会减）
	public void test6(){

		if(num<=0){
			flag = false;
			return;//跳出循环
		}
		
		//a b c
		synchronized(this){
			
			try {
				Thread.sleep(500);//加延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了票"+num--);
		}
	}
	
	//线程不安全 锁定资源不正确（并没有锁定this(a b c)同一个数可能被多次取到）
	public void test5(){
		
		//a b c
		synchronized((Integer)num){
			
			if(num<=0){
				flag = false;
				return;//跳出循环
			}
			try {
				Thread.sleep(500);//加延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了票"+num--);
		}
	}
		
	
	//锁定范围不正确
		public void test4(){
			
			synchronized(this){
				
				if(num<=0){
					flag = false;
					return;//跳出循环
				}
			}
			try {
				Thread.sleep(500);//加延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了票"+num--);
		}
	
	
	//线程安全 锁定正确
	public void test3(){
		
		synchronized(this){//锁定线程
			
			if(num<=0){
				flag = false;
				return;//跳出循环
			}
			try {
				Thread.sleep(500);//加延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了票"+num--);
		}
	}
		
	
	
	//线程安全 锁定正确
	public synchronized void test2(){
		if(num<=0){
			flag = false;
			return;//跳出循环
		}
		try {
			Thread.sleep(500);//加延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了票"+num--);
	}
	
	
	//线程不安全
	public void test1(){
		if(num<=0){
			flag = false;
			return;//跳出循环
		}
		try {
			Thread.sleep(500);//注意加延时后数据变得不准确 出现0,-1 并发问题 abc都在里面导致
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了票"+num--);
	}
}