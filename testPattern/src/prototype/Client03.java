package prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Use serialization or re-serialization for deep copy
 * 
 * @author y.yin
 *
 */
public class Client03 {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		
		Date date =  new Date(12345678L);
		Sheep s1 = new Sheep("old sheep", date);//pointer points to date
		
//		Sheep s2 = (Sheep) s1.clone();//the birthday object of s2 is the original one

		//Using serialization or re-serialization for deep copy
		//serialization
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(s1);
		byte[] bytes = bos.toByteArray();
		
		//re-serialization
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Sheep s2 = (Sheep) ois.readObject();
		//new clone sheep
		
		s2.setSname("new sheep");
		
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
		
    	date.setTime(987564321L);
		System.out.println(s1.getBirthday());
		System.out.println(s2.getBirthday());
		
	}
}
