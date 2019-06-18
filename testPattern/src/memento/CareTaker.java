package memento;

import java.util.Stack;

/**
 * be in charge of memento management
 * 
 * @author y.yin
 *
 */
public class CareTaker {

	private EmpMemento memento;
	
	//save more mementos
//	private List<EmpMemento> list = new ArrayList<EmpMemento>();
	
	//or use stack FILO LIFO
//	private Stack<EmpMemento> stack = new Stack<EmpMemento>();

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}
	
	
}
