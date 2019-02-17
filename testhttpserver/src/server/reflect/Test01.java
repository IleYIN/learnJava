package server.reflect;
//Class对象获取的三种方法

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abc";
	
		Class<?> clz = str.getClass();
		clz = String.class;
		clz = Class.forName("java.lang.String");
	}
}
