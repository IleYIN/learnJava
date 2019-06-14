package prototype;

import java.util.Date;

/**
 * test prototype(shallow copy)
 * 
 * @author y.yin
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Date date =  new Date(12345678L);
		Sheep s1 = new Sheep("old sheep", date);//pointer points to date
		Sheep s2 = (Sheep) s1.clone();//the birthday object of s2 is the original one
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
