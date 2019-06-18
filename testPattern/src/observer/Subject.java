package observer;

import java.util.List;
import java.util.ArrayList;

public class Subject {
	protected List<Observer> list = new ArrayList<Observer>();
	
	public void registerObserver(Observer obs) {
		list.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		list.remove(obs);
	}
	
	public void notifyAllObservers() {
		for (Observer observer : list) {
			observer.update(this);
		}
	}
}
