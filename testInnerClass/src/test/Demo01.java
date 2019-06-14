package test;

//test inner class definition

public class Demo01 {

	//static inner class
	private static class StaticNestedClass{
		
	}
	
	//general inner class(member)
	private class FieldInnerClass{
		
	}
	
	void sayHello() {
		
		//method inner class(local inner class)
		class LocalClass{
			
		}
		
		//anonymous inner class
		Runnable runnable = new Runnable() {
			//multi-thread interface; define the anonymous class and an instance of this class(not new interface)

			@Override
			public void run() {
			}
			
		};
	}
}
