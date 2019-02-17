package testGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * extends : ���͵����� <= ������
 * һ���������Ʋ���
 * ����ʹ��������������棬һ�㶼�Ƕ�ȡ����
 * ����
 * List<Fruit>-->List<? extends Fruit>
 * List<Apple>-->List<? extends Fruit>
 * List<? extends Apple>-->List<? extends Fruit>
 * 
 * ���ܴ��
 * List<?>
 * List<? extends Object>
 * 
 * @author yinyiliang
 *
 */

public class ExtendsFruit {
	
	
	static class Test<T extends Fruit>{
		
	}
	
	public static void test(List <? extends Fruit> list){
		
//		list.add(new Apple());������
//		list.add(new FujiApple());������
//		list.add(new Pear());������
//		list.add(new Fruit());������
		list.add(null);//���Լӿն�����Ϊ�ն������κ�һ�����Ͷ�����ʹ�õ�ֵ
	}
	
	public static void main(String[] args) {
		
		Test<Fruit> t1 = new Test<Fruit>();
		Test<Apple> t2 = new Test<Apple>();
		Test<Pear> t3 = new Test<Pear>();
		
		List<? extends Fruit> list1 = new ArrayList<Fruit>();
		test(list1);
		
		List<Fruit> list2 = new ArrayList<Fruit>();
		test(list2);
		
		List<Apple> list3 = new ArrayList<Apple>();
		test(list3);
		
		List<? extends Apple> list4 = new ArrayList<FujiApple>();//FujiApple��Apple����������Apple����
		test(list4);
	
		List<?> list5 = new ArrayList<Object>();
//		test(list5);ֻ���ʺŲ��� ?��ͬ��? extends Object
		List<? extends Object> list6 = new ArrayList<Object>();
	
		List<FujiApple> app = new ArrayList<FujiApple>();
		test(app);
		
		
	}
	
}
