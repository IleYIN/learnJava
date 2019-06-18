package command;

public interface Command {

	void execute();
	//we can design different methods according to requirements
}

class ConcreteCommand implements Command {

	private Receiver receiver;//true executer of command
	
	
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}


	@Override
	public void execute() {

		//after execution of command
		receiver.action();
	}
	
}
