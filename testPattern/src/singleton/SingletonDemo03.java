package singleton;
/**
 * double check lock (not recommended)
 * 
 * probably have problems with JVM
 * 
 * @author y.yin
 *
 */
public class SingletonDemo03 {

	private static SingletonDemo03 instance;
	
	private SingletonDemo03() {
	}
	
	public static SingletonDemo03 getInstance() {
		if(instance == null) {
			SingletonDemo03 sc;
			synchronized (SingletonDemo03.class){
				sc = instance;
				if(sc == null) {
					sc = new SingletonDemo03();
				}
			} 
			instance = sc;
		}
		return instance;
	}
}
