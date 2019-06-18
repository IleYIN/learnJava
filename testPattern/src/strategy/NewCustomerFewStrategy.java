package strategy;

public class NewCustomerFewStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("no dicounts, original price");
		return standardPrice;
	}

}
