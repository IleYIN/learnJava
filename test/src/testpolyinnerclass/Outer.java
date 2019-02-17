package testpolyinnerclass;

public class Outer {
	public static void main(String[] args) {
		Face f = new Face();
		Face.Nose n = f. new Nose(); //必须先用外部类，不能直接写内部类
		//或直接写	Face.Nose n2 = new Face.Nose();
		
		n.breath();

		Face.Ear e = new Face.Ear();
		e.listen();
	}
}

class Face {
	int type;
	String shape = "瓜子脸";
	static String color = "红润";
	
	class Nose {
		String type;
		void breath() {
			System.out.println(this.type);//内部的type
			System.out.println(Face.this.type);//外部的type
			System.out.println(shape); //如果不重名，则直接是指外部的
			System.out.println("呼吸");
		}
	}
	
	static class Ear {
		void listen() {
			//这个是错误的，因为静态内部类里没有普通属性shape，它是从属于类而不是从属于外部类对象。System.out.println(shape);
			System.out.println(color);  //但是可以访问外部类的静态属性color
			System.out.println("听");
		}
	}
}