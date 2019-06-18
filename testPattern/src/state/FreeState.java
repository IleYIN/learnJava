package state;

public class FreeState implements State {

	@Override
	public void handle() {
		System.out.println("free");
	}

}
