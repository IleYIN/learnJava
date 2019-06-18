package mediator;

public class Development implements Department {

	private Mediator m;//refer to the general manager
	
	public Development(Mediator m) {
		super();
		this.m = m;
		m.register("development", this);
	}

	@Override
	public void selfAction() {
		System.out.println("do development");
	}

	@Override
	public void outAction() {
		System.out.println("developpers report to the general manager");
	}

}
