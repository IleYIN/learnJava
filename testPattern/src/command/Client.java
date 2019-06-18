package command;

public class Client {

	public static void main(String[] args) {
		Command c = new ConcreteCommand(new Receiver());
		
		Invoker i = new Invoker(c);
		
		i.call();
		/**
		 * avoid direct relation between receiver and client
		 */
		//new Receiver().action();
	}
}
