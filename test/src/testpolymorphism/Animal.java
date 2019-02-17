package testpolymorphism;

public class Animal {

	String str;
	public void voice(){
		System.out.println("¶¯Îï½ĞÉù");
	}
}

class Cat extends Animal {
	//ÖØĞ´
	public void voice(){
		System.out.println("Ã¨½ĞÉù");
	}
	public void catchMouse(){
		System.out.println("Catch mouses");
	}
}

class Dog extends Animal {
	//ÖØĞ´
	public void voice(){
		System.out.println("¹·½ĞÉù");
	}
}


class Pig extends Animal {
	//ÖØĞ´
	public void voice(){
		System.out.println("Öí½ĞÉù");
	}
}