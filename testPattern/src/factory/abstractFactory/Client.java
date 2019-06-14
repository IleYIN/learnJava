package factory.abstractFactory;
/**
 * abstract factory
 * 
 * to product a series of products
 * 
 * @author y.yin
 *
 */

public class Client {
	public static void main(String[] args) {
		CarFactory fact = new LuxuryCarFactory();
		Engine e = fact.createEngine();
		e.run();
		e.start();
	}
}

