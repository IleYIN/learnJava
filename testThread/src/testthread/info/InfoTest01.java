package testthread.info;
/**
 * Thread.currentThread --> 静态方法 写在哪个线程里是哪个线程的
 * setName()
 * getName()
 * isAlive()判断状态
 * 
 * 
 * @author yinyiliang
 *
 */
public class InfoTest01 {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread t1 = new MyThread();//创建线程 
		Thread proxy = new Thread(t1,"t1");//Thread来实现Runnable接口 可以设置名称
//		proxy.setName("test");//也可以这样设置名称
		
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());//当前线程也就是main线程
		
		proxy.start();
		System.out.println("启动后的状态:"+proxy.isAlive());
		Thread.sleep(200);
		t1.stop();
		Thread.sleep(100);
		System.out.println("停止后的状态:"+proxy.isAlive());
		
	}
}
