package state;

public class BookedState implements State {

	@Override
	public void handle() {
		System.out.println("booked");
	}

}
