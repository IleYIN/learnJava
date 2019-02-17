package testthread.producer;
/**
 * 一个场景，共同的资源
 * 生产者消费者模式 信号灯法
 * 
 * wait和notify是和synchronized一起使用
 * notify():唤醒   notifyAll()
 * wait():等待且释放锁否则无法进行下一步操作  
 * sleep不释放锁
 * 
 * @author yinyiliang
 *
 */
public class Movie {

	private String pic;
	
	//信号灯
	//flag-->True  生产者生产，消费者等待，生产完成后通知消费
	//flag-->False 消费者消费，生产者等待，消费完后通知生产
	private boolean flag = true;
	
	
	/**
	 * 播放
	 */
	public synchronized void play(String pic){
		
		if(!flag){//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//生产完毕
		this.pic = pic;
		System.out.println("生产了："+pic);
		
		//通知消费
		this.notify();
		
		//生产者停下
		this.flag = false;
	}
	
	/**
	 * 查看
	 */
	public synchronized void watch(){
		
		if(flag){//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//消费完毕
		System.out.println("消费了："+pic);
		
		//通知生产
		this.notifyAll();
		
		//停止消费
		this.flag = true;
	}
}
