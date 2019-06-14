package bridge;
/**
 * brand of computer
 * 
 * @author y.yin
 *
 */
public interface Brand {
	void sale();
}

class Lenovo implements Brand {

	@Override
	public void sale() {
		System.out.print("sell Lenovo");
	}
}

class Dell implements Brand {

	@Override
	public void sale() {
		System.out.print("sell Dell");
	}
}

class Shenzhou implements Brand {

	@Override
	public void sale() {
		System.out.print("sell Shenzhou");
	}
}