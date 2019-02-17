package testthread.status;

/**
 * sleep模拟网络延时 线程不安全的类（多线程访问同一资源出现问题-->并发）
 * 
 * @author yinyiliang
 *
 */
public class SleepTest02 {

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

	private int num = 50;
	
	@Override
	public void run() {
		while(true){
			if(num<=0){
				break;//跳出循环
			}
			try {
				Thread.sleep(500);//注意加延时后数据变得不准确 出现0,-1 并发问题 abc都在里面导致
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了票"+num--);
		}
	}
	
	
}
