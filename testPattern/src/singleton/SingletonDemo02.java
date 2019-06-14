package singleton;

/**
 * lazy singleton mode
 * 
 * resource utilization rate high, need to synchronize, low efficiency of multi-threads
 * 
 * @author y.yin
 *
 */
public class SingletonDemo02 {
	
	private static SingletonDemo02 s;
	
	private SingletonDemo02() {
		
	}
	
	//lazy load
	public static synchronized SingletonDemo02 getInstance() {
		if(s==null) {
			s = new SingletonDemo02();
		}
		return s;
	}
}
