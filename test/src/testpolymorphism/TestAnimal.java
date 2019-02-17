package testpolymorphism;

public class TestAnimal {

	public static void testAnimalVoice(Animal c) {
		c.voice();
	//if c is an instance of Cat, then cast强转
		if (c instanceof Cat){
			((Cat) c).catchMouse();
		}
	}
	
//	//重载
//	public static void testAnimalVoice(Dog c) {
//		c.voice();
//	}
//	//重载
//	public static void testAnimalVoice(Pig c) {
//		c.voice();
//	}

	
	public static void main (String[] args) {

		Animal a = new Cat();
		
	//不行因为编译时Animal里没有catchMouse	需要强制转型	a.catchMouse();
		Cat a2 = (Cat)a;
		a2.catchMouse();
		testAnimalVoice(a);
		
		
		Animal b = new Dog();
		Animal c = new Pig();
		
//		Cat c = new Cat(); //运行时类型
//		Animal a = c;
//		testAnimalVoice (a);
		

		testAnimalVoice(b);
		testAnimalVoice(c);
		

	}
}
