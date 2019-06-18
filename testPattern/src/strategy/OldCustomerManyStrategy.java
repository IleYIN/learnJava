package strategy;

public class OldCustomerManyStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("dicounts 0.8");
		return standardPrice*0.8;
	}

}
