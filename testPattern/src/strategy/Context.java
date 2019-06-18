package strategy;
/**
 * interact with strategy
 * separate algorithms and clients
 * choose dynamically different algorithms by setter or constructor
 * @author y.yin
 *
 */
public class Context {

	private Strategy strategy;// chosen strategy

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void printPrice(double s) {
		System.out.println("Price:"+strategy.getPrice(s));
	}
}
