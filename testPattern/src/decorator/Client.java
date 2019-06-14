package decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Client {

	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		
		System.out.println("--add new fly function");
		FlyCar flycar = new FlyCar(car);
		flycar.move();
		
		System.out.println("--add new swim function");
		WaterCar waterCar = new WaterCar(flycar);
		waterCar.move();
		
		System.out.println("--add all together");
		AICar aicar = new AICar(new WaterCar(new FlyCar(car)));
		aicar.move();
		
		
		try {
			Reader r = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/test.txt"))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
