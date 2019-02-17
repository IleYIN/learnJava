package testGeneric;

/**
 * 通配符 问号
 * 问号只能输出或接收 不能修改
 * 问号的使用 只能在声明类型或方法时用，不能对类进行声明或者应用时用
 * ？使用：
 * ? extends: <= 上限 
 * ? super :  >= 下限 
 * 
 * 
 * 
 * @author yinyiliang
 *
 * @param <T>
 */
public class StudentWenhao<T>{
	T score;
	
	public static void test(StudentWenhao<?> stu) {
		
	}
	
	public static void test2(StudentWenhao<? extends Fruit> stu) {
		
	}
	
	public static void test3(StudentWenhao<Fruit> stu) {
		
	}
	
	public static void test4(StudentWenhao<? super Fruit> stu) {
		
	}
	
	public static void main(String[] args) {
		StudentWenhao<?> stu = new StudentWenhao<String>();
		test(new StudentWenhao<Integer>());
		test2(new StudentWenhao<Apple>());
//		test3(new StudentWenhao<Apple>());错误，泛型没有多态
		test4(new StudentWenhao<Fruit>());
		test4(new StudentWenhao<Object>());
		
//		下面的都不行，因为使用时要确定类型
//		test4(new StudentWenhao<?>());
		stu = new StudentWenhao<Fruit>();
//		test4(stu);  
		
	}



}
