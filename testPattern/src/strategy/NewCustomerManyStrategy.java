package strategy;

public class NewCustomerManyStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("dicounts 0.9");
		return standardPrice*0.9;
	}

}
