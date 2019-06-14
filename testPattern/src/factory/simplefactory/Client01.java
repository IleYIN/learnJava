package factory.simplefactory;

/**
 * test without factory mode
 * 
 * @author y.yin
 *
 */

public class Client01 {//user needs how to create a new object 
	
	public static void main(String[] args) {
		Car c1 = new Audi();
		Car c2 = new Byd();
		
		c1.run();
		c2.run();
	}
}
