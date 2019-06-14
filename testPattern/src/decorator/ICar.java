package decorator;
/**
 * For adding new functions
 * 
 * @author y.yin
 *
 */
//component
public interface ICar {
	void move();
}


//concrete component
class Car implements ICar {

	@Override
	public void move() {
		System.out.println("run on the road");
	}
}

//abstract decorator
abstract class SuperCar implements ICar {
	protected ICar car;

	public SuperCar(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		car.move();
	}
}

class FlyCar extends SuperCar {

	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("fly over sky");
	}
	
	@Override
	public void move() {
		super.move();
		fly();
	}
}

class WaterCar extends SuperCar {

	public WaterCar(ICar car) {
		super(car);
	}
	
	public void swim() {
		System.out.println("swim in the water");
	}
	
	@Override
	public void move() {
		super.move();
		swim();
	}
}

class AICar extends SuperCar {

	public AICar(ICar car) {
		super(car);
	}
	
	public void autoMove() {
		System.out.println("auto move");
	}
	
	@Override
	public void move() {
		super.move();
		autoMove();
	}
}