package singleton;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**
 * compare efficiency of these 5 methods
 * 
 * @author y.yin
 *
 */
public class Client03 implements Serializable {

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();
		int threadNum = 10;
		final CountDownLatch c = new CountDownLatch(threadNum);
		
		for(int i=0;i<10;i++) {
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					for(int i=0; i<100000;i++) {
						Object o = SingletonDemo02.getInstance();
//						Object o = SingletonDemo05.INSTANCE;
					}
					
					c.countDown();
				}
			}).start();
		}
		
		c.await();//wait until count 0, continue
		
		long end = System.currentTimeMillis();
		System.out.println("total time: "+(end-start));
	}
}
