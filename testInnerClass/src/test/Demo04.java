package test;

/**
 * test method inner class (local inner class)
 * @author y.yin
 *
 */
public class Demo04 {

	public static void main(String[] args) {

	}

}

class Outer04 {

	public void test() {
		final int a = 3;

		class Inner{//cannot use public or private...
			//method inner class can only be seen within the method.

			int b = 10;
			//			static int c = 20; impossible, method inner class can only define non-static member

			void tt() {
				System.out.println(b);
				System.out.println(a);
				//method inner class can't use the general local variable in the method, except it's final
				//because life cycle of the method is different from that of the method inner class object
				//inner class object is in the pile, method is in the stack
				//perhaps method doesn't exist while the class use the variable in the method
				//final variable is copied in the pile
			}
			
			
		}
		Inner i = new Inner();
		//method inner class can only be seen within the method.
	}



	void test2() {
		//		Inner i = new Inner(); impossible
	}
}
