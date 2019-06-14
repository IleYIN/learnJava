package factory.abstractFactory;

public interface Engine {

	void run();
	void start();
}

class LuxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("run fast");
	}

	@Override
	public void start() {
		System.out.println("start fast");
	}
	
}

class LowEngine implements Engine{

	@Override
	public void run() {
		System.out.println("run slowly");
	}

	@Override
	public void start() {
		System.out.println("start slowly");
	}
	
}
