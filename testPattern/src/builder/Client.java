package builder;
/**
 * when you develop a product which needs to assembly a lot of parts
 * builder mode
 * 
 * @author y.yin
 *
 */
public class Client {

	public static void main(String[] args) {
		
		AirshipDirector director = new MyAirshipDirector(new MyAirshipBuilder());
		Airship ship = director.directAirship();
		
		System.out.println(ship.getEngine().getName());
		ship.launch();
	}
	
	
	
}
