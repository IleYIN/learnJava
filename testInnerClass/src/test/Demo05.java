package test;

/**
 * anonymous inner class is used for one time
 * @author y.yin
 *
 */

public class Demo05 {

	public static void main(String[] args) {
		Outer05 out = new Outer05();
		out.test();
	}
}

class Outer05 {
	
	public void test02(Car c) {
		c.run();
	}
	
	public void test() {
		
		final int a = 3;
		
		//anonymous inner class (interface)
		//it's also a method inner class as it's defined inside a method
		Runnable runnable = new Runnable() {//new class object not interface

			@Override
			public void run() {
		
			}
		};
		
		//anonymous inner class (inheritance)
		Car car = new Car() {
			@Override
			public void run() {
				System.out.println("son class car!");
				System.out.println(a);
			}
		};
		
		car.run();
		
		
		//anonymous inner class (parameter)
		test02(new Car(){
			@Override
			public void run() {
				System.out.println("parameter inner class - car is running!");
			}
		});
	}
}

class Car{
	public void run() {
		
	}
}
