package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * lazy singleton mode (Prevent Reflection and ReSerialisation)
 * 
 * resource utilization rate high, need to synchronize, low efficiency of multi-threads
 * 
 * @author y.yin
 *
 */
public class SingletonDemo06 implements Serializable {
	
	private static SingletonDemo06 s;
	
	private SingletonDemo06() {
		if(s!=null) {
			throw new RuntimeException();//when it's been called for more than one time, throw exception
		}
		
	}
	
	//lazy load
	public static synchronized SingletonDemo06 getInstance() {
		if(s==null) {
			s = new SingletonDemo06();
		}
		return s;
	}
	
	//re-serialization, when it's defined, it won't create a new object
	private Object readResolve() throws ObjectStreamException {
		return s;
	}
}

