package command;

public class Invoker {

	private Command command;//or List<Command> to contain a lot of commands

	public Invoker(Command command) {
		super();
		this.command = command;
	}
	
	public void call() {
		command.execute();
	}
}
