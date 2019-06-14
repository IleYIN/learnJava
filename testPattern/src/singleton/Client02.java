package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * test reflection and re-serialization
 * 
 * @author y.yin
 *
 */
public class Client02 implements Serializable {

	public static void main(String[] args) throws Exception {
		SingletonDemo06 s1 = SingletonDemo06.getInstance();
		SingletonDemo06 s2 = SingletonDemo06.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
//		//use directly the private constructor by reflection
//		Class<SingletonDemo06> clazz = (Class<SingletonDemo06>) Class.forName("singleton.SingletonDemo06");
//		Constructor<SingletonDemo06> c = clazz.getDeclaredConstructor(null);
//		c.setAccessible(true);
//		
//		SingletonDemo06 s3 = c.newInstance();
//		SingletonDemo06 s4 = c.newInstance();
//		
//		System.out.println(s3);
//		System.out.println(s4);
		
		//use re-serialization method to create more objects
		FileOutputStream fos = new FileOutputStream("D:/y.yin/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/y.yin/a.txt"));
		SingletonDemo06 s3 = (SingletonDemo06) ois.readObject();
		System.out.println(s3);
		
	}
}
