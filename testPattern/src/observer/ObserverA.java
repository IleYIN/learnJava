package observer;

public class ObserverA implements Observer {
	
	private int myState; //coordinate with object state
	
	@Override
	public void update(Subject subject) {
		myState = ((ConcreteSubject)subject).getState();
	}
	
	public int getMyState() {
		return myState;
	}

}
