package testGeneric;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * 泛型方法 <>放在修饰符后面，返回类型的前面
 * 泛型方法只能访问对象的信息，不能修改信息如a.set，因为类型不定
 * @author yinyiliang
 *
 */

public class TestMethod {
	
	public static <T> void test(T a){
		System.out.println(a);
	}
	
	public static <T extends Closeable> void test(T... a){
		System.out.println(a); //T只能是Closeable接口的实现类
		//T...表示可变参数，使用方法与数组一致
		//Java中类型后面跟三个点表示其参数的个数是不确定的，传递多少个参数都是可以的
		for(T temp:a){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static <T extends List> void test(T t){
		System.out.println(t); 
		t.add("aaa");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		test("字符串");
		test(new FileInputStream("a.txt"));
	}
	
}
