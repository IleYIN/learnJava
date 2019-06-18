package mediator;

public class Financial implements Department {

	private Mediator m;//refer to the general manager
	
	public Financial(Mediator m) {
		super();
		this.m = m;
		m.register("financial", this);
	}

	@Override
	public void selfAction() {
		System.out.println("financial counting");
	}

	@Override
	public void outAction() {
		System.out.println("accountants report to the general manager");
	}

}
