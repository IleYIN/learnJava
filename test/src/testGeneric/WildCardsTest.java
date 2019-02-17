package testGeneric;

/**
 *  ?-->通配符，类型不确定，用于声明变量或形参上
 *  不能用在创建对象或类或方法或接口上
 */


import java.util.ArrayList;
import java.util.List;

public class WildCardsTest {
	
	public static void test(List<?> list){
		
	}
	
//	public static <?> void test2(List<?> list){
//		问号不能用来创建泛型方法
//	}
	
	public static void main(String[] args) {
		//声明
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		list = new ArrayList<Object>();
		test(list);
		
		//编译错误
		//list = new ArrayList<?>();
		
	}
	
	class Test<T>{
		
	}
	
//	class Test2<?>{
//	问号不能创建泛型类	
//	}
	

}
