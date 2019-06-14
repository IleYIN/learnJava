package adapter;
/**
 * user
 * 
 * @author y.yin
 *
 */
public class Client {

	public void test1(Target t) {
		t.handleRq();
	}
	
	public static void main(String[] args) {
		Client c = new Client();
//		Target t = new Adapter();
		
		Adaptee a = new Adaptee();
		Target t = new Adapter02(a);
		
		c.test1(t);
	}
}
