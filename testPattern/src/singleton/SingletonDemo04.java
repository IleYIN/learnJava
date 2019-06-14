package singleton;

/**
 * static inner class (recommended)
 * 
 * @author y.yin
 *
 */
public class SingletonDemo04 {
	
	//Outer Class won't be loaded until the getInstance method is called

	private static class SingletonClassInstance{
		
		private static final SingletonDemo04 instance = new SingletonDemo04();
		
	}
	
	public static SingletonDemo04 getInstance() {
		return SingletonClassInstance.instance;
	}
	
	private SingletonDemo04() {
		
	}
}
