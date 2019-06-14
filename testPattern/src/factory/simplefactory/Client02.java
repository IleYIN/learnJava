package factory.simplefactory;
/**
 * OOP Principles
 * OCP: Open to extension, close to modification
 * DIP: depend on interface not on implementation
 * LoD: only connect to friends not strangers
 * 
 * 
 * Simple Factory Mode
 * 
 * 
 * @author y.yin
 *
 */

public class Client02 {//user doesn't need to know how to create

	public static void main(String[] args) {
		Car c1 = CarFactory.createCar("Audi");
		Car c2 = CarFactory.createCar("Byd");
		
		c1.run();
		c2.run();
	}
}
