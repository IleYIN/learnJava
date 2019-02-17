package testGeneric;

/**
 * 泛型没有多态：此错误的是List<Fruit> list = new ArrayList<Apple>();错误
 *  想实现的话用? extends super
 *  
 *  
 * @author yinyiliang
 *
 */

public class ATest {
	//形参使用多态
	public static void test(A<Fruit> f){
		
	}
	//返回类型使用多态
	public static A<Fruit> test2(){
		return new A<Fruit>();
//		return  (A<Fruit>)(new A<Apple>());
		//强转也不行，因为A<Apple>就不是A<Fruit>的多态
	}
	public static void main(String[] args) {
//		A<Fruit> f1 = new A<Apple>();这样写不行
		A<Fruit> f2 = new A<Fruit>();
		
		test(f2);
//		test(new A<Apple>());这样写不行
		test(new A<Fruit>());
	}
}
