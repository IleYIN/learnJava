package strategy;

public class OldCustomerFewStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("dicounts 0.85");
		return standardPrice*0.85;
	}

}
