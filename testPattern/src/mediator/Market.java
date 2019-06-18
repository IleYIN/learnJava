package mediator;

public class Market implements Department {

	private Mediator m;//refer to the general manager
	
	public Market(Mediator m) {
		super();
		this.m = m;
		m.register("market", this);
	}

	@Override
	public void selfAction() {
		System.out.println("research on markets");
	}

	@Override
	public void outAction() {
		System.out.println("market report to the general manager");
		m.command("financial");
	}

}
