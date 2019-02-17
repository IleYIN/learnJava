package test02Animal;

/**
 * package test02Animal;
 * @author yinyiliang
 * 测试组合
 */


	public class Animal2 {

		public void run(){
			System.out.println("跳跳");
		}
		public void eat(){
			System.out.println("吃吃");
		}
		public void sleep(){
			System.out.println("zzzz");
		}
		
		//默认包含构造器和第一行的super()
		
		public Animal2() {
			super();
			System.out.println("建一个动物");
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
			System.out.println("我是胎生");
		}
	}

	class Bird2 {
		Animal2 animal2 = new Animal2();
		public void luansheng(){
			System.out.println("我是卵生");
		}
		public void run(){
			animal2.run(); //调用父类Animal的run
			System.out.println("飞飞");
			//重写run
		}
		
		
	}