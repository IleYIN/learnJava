package factory.abstractFactory;

public interface Seat {
	void massage();
}

class LuxurySeat implements Seat {

	@Override
	public void massage() {
		System.out.println("massage automatically");
	}
	
}

class LowSeat implements Seat {

	@Override
	public void massage() {
		System.out.println("cannot massage");
	}
	
}