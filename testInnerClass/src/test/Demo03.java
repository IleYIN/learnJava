package test;

public class Demo03 {
	//non-related class
	
	public static void main(String[] args) {
		
		Outer03 out = new Outer03();
		//mermber inner class object must have its outer class object!
		Outer03.InnerClass ic = out.new InnerClass();
		ic.test();
	}
}

//inner class can use the members of the outer class
//inner class is often used to offer the service only for the outer class
//if the inner class is used for many classes, we use a normal class instead of an inner class
class Outer03 {
	
	private int a = 3;
	static int b = 10;
	
	public void ttt() {
		//no need to create an outer class object, because it's a method of Outer03, the object should already exist
		InnerClass ic = new InnerClass();
	}
	
	//member class can use all the members of outer class
	class InnerClass{
		
		int c = 1;
//		static int d = 80; member inner class can't have a static member, except it's final and the expression can be considered final by the compiler
		final static int d = 80;
//		final static Date d2 = new Date();//and the expression should be final too (new Date() is not)
		
//		static InnerClass ab = new InnerClass();//Outer03.InnerClass.ab
	//can't create a static class, because static class can be independent of the outer class, it's contrary to the member inner class; it can be created only when the class is static
		
		void test() {
			System.out.println(a);
			System.out.println(b);
			System.out.println("inner class object:"+this);//this means the inner class object 
			//mermber inner class object must have its outer class object!
			System.out.println("outer class object:"+Outer03.this);
		}
	}
}