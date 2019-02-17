package annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo01  {

	@Override//表示继承父类方法
	public String toString() {
		return super.toString();
	}
	
	@Deprecated//被遗弃的 不建议使用
	public static void test1() {
		
	}
	
	@SuppressWarnings("all")//压制警告
	//@SuppressWarnings(value = "unchecked","deprecation")
	public static void test2() {
		List list = new ArrayList();
		List list2 = new ArrayList();
		
	}
	
	public static void main(String[] args) {
		test1();
	}
}
