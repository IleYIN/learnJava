package testGeneric;

/**
 * ��̬��������ʽ
 * @author yinyiliang
 *
 */

public class TestFruit {
	//�β�ʹ�ö�̬
	public static void test(Fruit f){
		
	}
	//��������ʹ�ö�̬
	public static Fruit test2(){
		return new Apple();
	}
	
	
	public static void main(String[] args) {
		Fruit f = new Apple();
		test(f);
	}
}
