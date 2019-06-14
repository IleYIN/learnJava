package factory.abstractFactory;

public interface Tyre {

	void revolve();
}

class LuxuryTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("no wear and tear");
	}
	
}

class LowTyre implements Tyre {
	
	@Override
	public void revolve() {
		System.out.println("wear and tear");
	}
	
}