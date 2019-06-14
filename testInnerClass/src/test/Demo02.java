package test;

import test.Outer02.StaticInnerClass;

//test static inner class 

public class Demo02 {

	public static void main(String[] args) {
		Outer02.StaticInnerClass osic = new Outer02.StaticInnerClass();
//	or we can use
		//StaticInnerClass osic = new StaticInnerClass();//import test.Outer02.StaticInnerClass;
		//outerclass is like a package for the static inner class
		//however, if it's not a static inner class but a general inner class, we can't do like this
	}
}

class Outer02 {
	
	int c = 5;//outer class member
	
	static int d = 10;//outer class member
	
	
	void ttt() {
		StaticInnerClass sic = new StaticInnerClass();
	}
	
	//static inner class
	/* private */ static class StaticInnerClass{//outer class member
		
		int a = 3;//inner class member
		static int b = 5;
		
		public void test() {
			System.out.println(d);//can use a static member of outer class
//			System.out.println(c); cannot use a non-static member of outer class
		}
	}
}
