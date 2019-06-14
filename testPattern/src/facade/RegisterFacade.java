package facade;
/**
 * registration process facade object
 * 
 * @author y.yin
 *
 */
public class RegisterFacade {

	public void register() {
		new A().checkA();
		new B().checkB();
	}
}
