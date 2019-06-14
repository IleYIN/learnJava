package adapter;
/**
 * Adapter(Object method, use combination to adapt to the adaptee)
 * @author y.yin
 *
 */
public class Adapter02 implements Target {

	private Adaptee adaptee;
	
	@Override
	public void handleRq() {
		adaptee.request();
	}

	public Adapter02(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	
}
