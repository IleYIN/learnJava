package builder;

public class MyAirshipDirector implements AirshipDirector {

	private AirshipBuilder builder;
	
	
	public MyAirshipDirector(AirshipBuilder builder) {
		this.builder = builder;
	}


	@Override
	public Airship directAirship() {
		
		//build
		Engine e = builder.builderEngine();
		OrbitalModule o = builder.builderOrbitalModule();
		EscapeTower et = builder.builderEscapeTower();
		
		//assembly 
		Airship ship = new Airship();
		ship.setEngine(e);
		ship.setEscapeTower(et);
		ship.setOrbitalModule(o);
		return ship;
	}
}	
