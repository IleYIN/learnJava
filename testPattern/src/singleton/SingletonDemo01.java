package singleton;

/**
 * hungry singleton mode
 * 
 * @author y.yin
 *
 */
public class SingletonDemo01 {

	//when the class starts, load this object immediately!
	//thread safe, no need to synchronize, high efficiency
	private static SingletonDemo01 instance = new SingletonDemo01();
	
	private SingletonDemo01() {
		
	}
	
	public static SingletonDemo01 getInstance() {
		return instance;
	}
}
