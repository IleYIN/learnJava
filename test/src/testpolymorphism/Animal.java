package testpolymorphism;

public class Animal {

	String str;
	public void voice(){
		System.out.println("�������");
	}
}

class Cat extends Animal {
	//��д
	public void voice(){
		System.out.println("è����");
	}
	public void catchMouse(){
		System.out.println("Catch mouses");
	}
}

class Dog extends Animal {
	//��д
	public void voice(){
		System.out.println("������");
	}
}


class Pig extends Animal {
	//��д
	public void voice(){
		System.out.println("�����");
	}
}