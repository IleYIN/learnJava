package template;

public class Client {

	public static void main(String[] args) {
		BankTemplateMethod btm = new DrawMoney();
		btm.process();

		
		//define a new class or define an anonymous inner class
		BankTemplateMethod btm2 = new BankTemplateMethod() {
			
			@Override
			public void transact() {
				System.out.println("deposit money");
			}
		};
		
		btm2.process();
	}
	
	
	
}

class DrawMoney extends BankTemplateMethod{

	@Override
	public void transact() {
		System.out.println("draw money");
	}
	
}
