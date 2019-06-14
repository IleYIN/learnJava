package singleton;
/**
 * enumeration method (can't lazy load)(the most safe)
 * 
 * @author y.yin
 *
 */
public enum SingletonDemo05 {

	//this enumeration element is a singleton itself!
	INSTANCE;
	
	//add methods you need
	public void singletonOperation() {
		
	}
}
