package testGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * extends : 泛型的上限 <= 即子类
 * 一般用于限制操作
 * 不能使用在添加数据上面，一般都是读取操作
 * 规则：
 * List<Fruit>-->List<? extends Fruit>
 * List<Apple>-->List<? extends Fruit>
 * List<? extends Apple>-->List<? extends Fruit>
 * 
 * 不能存放
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
		
//		list.add(new Apple());不能用
//		list.add(new FujiApple());不能用
//		list.add(new Pear());不能用
//		list.add(new Fruit());不能用
		list.add(null);//可以加空对象，因为空对象是任何一个类型都可以使用的值
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
		
		List<? extends Apple> list4 = new ArrayList<FujiApple>();//FujiApple是Apple的子类或就是Apple才行
		test(list4);
	
		List<?> list5 = new ArrayList<Object>();
//		test(list5);只有问号不行 ?等同于? extends Object
		List<? extends Object> list6 = new ArrayList<Object>();
	
		List<FujiApple> app = new ArrayList<FujiApple>();
		test(app);
		
		
	}
	
}
