/**
 * ���Լ̳�
 */
 
package test02Animal;

public class Animal {

	public void run(){
		System.out.println("����");
	}
	public void eat(){
		System.out.println("�Գ�");
	}
	public void sleep(){
		System.out.println("zzzz");
	}
	
	//Ĭ�ϰ����������͵�һ�е�super()
	
	public Animal() {
		super();
		System.out.println("��һ������");
	}
}

class Mammal extends Animal {
	public void taisheng(){
		System.out.println("����̥��");
	}
}

class Bird extends Animal {
	
	public void luansheng(){
		System.out.println("��������");
	}
	public void run(){
		super.run(); //���ø���Animal��run
		System.out.println("�ɷ�");
		//��дrun
	}
	//Ĭ�ϰ����������͵�һ�е�super()
	
		public Bird() {
			super();
			System.out.println("��һ������");
		}
}