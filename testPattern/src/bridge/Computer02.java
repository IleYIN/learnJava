package bridge;
/**
 * For multi-dimensions
 * 
 * type of computer
 * 
 * @author y.yin
 *
 */
public abstract class Computer02 {
	//we don't use interface here cuz we need to add a brand property
	protected Brand brand;

	public Computer02(Brand brand) {
		this.brand = brand;
	}
	
	public void sale() {
		brand.sale();
	}
}


class Desktop02 extends Computer02 {

	public Desktop02(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println(" desktop");
	}
}

class Laptop02 extends Computer02 {
	
	public Laptop02(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println(" laptop");
	}
}

class Pad02 extends Computer02 {
	 public Pad02(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		 super.sale();
		 System.out.println(" pad");
	 }
}