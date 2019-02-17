/**
 * 测试继承
 */
 
package test02Animal;

public class Animal {

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
	
	public Animal() {
		super();
		System.out.println("建一个动物");
	}
}

class Mammal extends Animal {
	public void taisheng(){
		System.out.println("我是胎生");
	}
}

class Bird extends Animal {
	
	public void luansheng(){
		System.out.println("我是卵生");
	}
	public void run(){
		super.run(); //调用父类Animal的run
		System.out.println("飞飞");
		//重写run
	}
	//默认包含构造器和第一行的super()
	
		public Bird() {
			super();
			System.out.println("建一个动物");
		}
}