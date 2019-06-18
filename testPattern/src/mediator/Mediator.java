package mediator;
/**
 * network->star 
 * one to many
 * 
 * @author y.yin
 *
 */

//general manager
public interface Mediator {

	void register(String dname, Department d);
	void command(String dname);
}
