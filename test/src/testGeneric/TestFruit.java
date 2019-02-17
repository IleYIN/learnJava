package testGeneric;

/**
 * 多态的两种形式
 * @author yinyiliang
 *
 */

public class TestFruit {
	//形参使用多态
	public static void test(Fruit f){
		
	}
	//返回类型使用多态
	public static Fruit test2(){
		return new Apple();
	}
	
	
	public static void main(String[] args) {
		Fruit f = new Apple();
		test(f);
	}
}
