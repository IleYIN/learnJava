package testEncapulation;

public class Test03 {
	private String str;
	public void print(){
		String s = str;
		System.out.print("Testprint");
	}
	
}

class Test0301 extends Test03{
	public void pp(){
		super.print();
		
	}
}