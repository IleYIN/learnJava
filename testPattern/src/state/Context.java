package state;

public class Context {
	
	private State state;
	
	public void setState(State s) {
		System.out.println("change state");
		state = s;
		state.handle();
	}
}
