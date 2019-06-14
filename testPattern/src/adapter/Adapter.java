package adapter;
/**
 * Adapter(Class Method)
 * 
 * create connection with the interface to adapt to the adaptee
 * 
 * @author y.yin
 *
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void handleRq() {
		super.request();
	}

}
