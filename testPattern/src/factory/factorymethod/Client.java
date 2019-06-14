package factory.factorymethod;
/**
 * comply to the OCP principle, when adds a new type, no need to change original codes
 * 
 * @author y.yin
 *
 */
public class Client {

	public static void main(String[] args) {
		Car c1 = new AudiFactory().createCar();
		Car c2 = new BydFactory().createCar();
		
		c1.run();
		c2.run();
	}
}
