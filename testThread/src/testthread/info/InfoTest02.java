package testthread.info;

/**
 * 优先级代表的是出现的概率 不是顺序 不是绝对的优先级
 * 
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5 （默认为5）
 * MIN_PRIORITY 1
 * 
 * @author yinyiliang
 *
 */
public class InfoTest02 {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread t1 = new MyThread();//创建线程 
		Thread p1 = new Thread(t1,"t1");
		
		MyThread t2 = new MyThread();//创建线程 
		Thread p2 = new Thread(t2,"t2");
		
		p1.setPriority(Thread.MIN_PRIORITY);//设置优先级
		p2.setPriority(Thread.MAX_PRIORITY);//设置优先级
		
		p1.start();
		p2.start();
		
		Thread.sleep(100);
		t1.stop();
		t2.stop();
	}
}
