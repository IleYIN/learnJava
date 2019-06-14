package prototype;

import java.util.Date;

/**
 * 
 * prototype (deep copy)
 * 
 * @author y.yin
 *
 */

public class Client02 {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		
		Date date =  new Date(12345678L);
		Sheep02 s1 = new Sheep02("old sheep", date);//pointer points to date
		Sheep02 s2 = (Sheep02) s1.clone();//the birthday object of s2 is a new object not the original pointer
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
