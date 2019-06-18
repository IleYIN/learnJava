package observer2;

import java.util.Observable;

public class ConcreteSubject extends Observable {

	private int state;
	
	public void set(int s) {
		state = s;
		setChanged();//object has changed
		notifyObservers(state);//inform all observers
	}

	public int getState() {
		return state;
	}

}
