package builder;

public class MyAirshipBuilder implements AirshipBuilder{
//StringBuilder, XML Analysis(JDOM): DomBuilder, SaxBuilder

	@Override
	public Engine builderEngine() {
		System.out.println("build my engine");
		return new Engine("MyEngine");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("build my orbital module");
		return new OrbitalModule("MyOrbitalModule");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		System.out.println("build my escape tower");
		return new EscapeTower("MyEscapeTower");
	}

}
