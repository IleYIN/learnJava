package test02Animal;

/**
 * package test02Animal;
 * @author yinyiliang
 * �������
 */


	public class Animal2 {

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
		
		public Animal2() {
			super();
			System.out.println("��һ������");
		}
		
		public static void main(String[] args) {
			Bird2 b = new Bird2();
			b.run();
			b.animal2.eat();
		}
	}

	

	class Mammal2 {
		Animal2 animal2 = new Animal2();
		public void taisheng(){
			System.out.println("����̥��");
		}
	}

	class Bird2 {
		Animal2 animal2 = new Animal2();
		public void luansheng(){
			System.out.println("��������");
		}
		public void run(){
			animal2.run(); //���ø���Animal��run
			System.out.println("�ɷ�");
			//��дrun
		}
		
		
	}