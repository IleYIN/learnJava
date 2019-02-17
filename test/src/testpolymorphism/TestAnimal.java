package testpolymorphism;

public class TestAnimal {

	public static void testAnimalVoice(Animal c) {
		c.voice();
	//if c is an instance of Cat, then castǿת
		if (c instanceof Cat){
			((Cat) c).catchMouse();
		}
	}
	
//	//����
//	public static void testAnimalVoice(Dog c) {
//		c.voice();
//	}
//	//����
//	public static void testAnimalVoice(Pig c) {
//		c.voice();
//	}

	
	public static void main (String[] args) {

		Animal a = new Cat();
		
	//������Ϊ����ʱAnimal��û��catchMouse	��Ҫǿ��ת��	a.catchMouse();
		Cat a2 = (Cat)a;
		a2.catchMouse();
		testAnimalVoice(a);
		
		
		Animal b = new Dog();
		Animal c = new Pig();
		
//		Cat c = new Cat(); //����ʱ����
//		Animal a = c;
//		testAnimalVoice (a);
		

		testAnimalVoice(b);
		testAnimalVoice(c);
		

	}
}
