package template;
/**
 * hook method
 * only parent class can call methods in child class
 *  
 * @author y.yin
 *
 */
public abstract class BankTemplateMethod {

	public void takeNumber() {
		System.out.println("take number");
	}
	
	public abstract void transact();//hook method, depend on subclass
	
	public void evaluate() {
		System.out.println("evaluate");
	}
	
	public final void process() {
		//template method, final, cannot be changed by subclass
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
	
}
