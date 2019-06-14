package bridge;

public class Client {

	public static void main(String[] args) {
		//sell Lenovo Laptop
		Computer02 c = new Laptop02(new Lenovo());
		c.sale();
		
		Computer02 c2 = new Pad02(new Shenzhou());
		c2.sale();
		System.out.println(c2.brand);
	}
}
