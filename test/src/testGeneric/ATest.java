package testGeneric;

/**
 * ����û�ж�̬���˴������List<Fruit> list = new ArrayList<Apple>();����
 *  ��ʵ�ֵĻ���? extends super
 *  
 *  
 * @author yinyiliang
 *
 */

public class ATest {
	//�β�ʹ�ö�̬
	public static void test(A<Fruit> f){
		
	}
	//��������ʹ�ö�̬
	public static A<Fruit> test2(){
		return new A<Fruit>();
//		return  (A<Fruit>)(new A<Apple>());
		//ǿתҲ���У���ΪA<Apple>�Ͳ���A<Fruit>�Ķ�̬
	}
	public static void main(String[] args) {
//		A<Fruit> f1 = new A<Apple>();����д����
		A<Fruit> f2 = new A<Fruit>();
		
		test(f2);
//		test(new A<Apple>());����д����
		test(new A<Fruit>());
	}
}
