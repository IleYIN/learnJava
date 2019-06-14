package bridge;

public interface Computer {
	void sale();
}

class Desktop implements Computer {

	@Override
	public void sale() {
		System.out.println("sell desktop");
	}
}

class Laptop implements Computer {

	@Override
	public void sale() {
		System.out.println("sell laptop");
	}
}

class Pad implements Computer {

	@Override
	public void sale() {
		System.out.println("sell pad");
	}
}

class LenovoDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("sell Lenovo desktop");
	}
}

class LenovoLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("sell Lenovo laptop");
	}
}

class LenovoPad extends Pad {
	@Override
	public void sale() {
		System.out.println("sell Lenovo pad");
	}
}

class DellDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("sell Dell desktop");
	}
}

class DellLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("sell Dell laptop");
	}
}

class DellPad extends Pad {
	@Override
	public void sale() {
		System.out.println("sell Dell pad");
	}
}
