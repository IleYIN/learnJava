package testCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCollection01 {
	
	public static void main(String[] args){
		List list = new ArrayList();
//		List list = new LinkedList(); 
//ArrayList底层实现是数组，查询速度很快插入修改删除慢
//LinkedList底层实现是链表（包含前后两个节点的位置和当前节点的值）查找慢插入修改删除快
//Vector:线程安全的，效率低；上面两个线程不安全但是效率高	
		
//		Collection list = new ArrayList();//也可用Collection，但是没有和顺序相关的操作
		
		
		list.add("aaa"); //添加对象
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);//包装类的：自动装箱成Integer
		list.add("aaa");
		
		System.out.println(list.size());//表示里面元素的长度而不是数组的长度
//		System.out.println(list.isEmpty());
//		list.remove(new Date());//尽管和上面的Date是两个对象，还是能移出去，和hashcode和equals判断相等有关
		list.remove(new String("aaa"));//这里能删掉是因为底层中的remove用的是equals比较的是值，而且删了一个就return了，所以不会删除下一个“aaa”
		System.out.println(list.size());
		
		for (int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		
//		List list2 = new ArrayList();
//		list2.add("bbb");
//		list2.add("ccc");
//		list2.add("eee");
//		
//		list.addAll(list2);
//		System.out.println(list.size());
//		System.out.println(list2.size());
//		
//		//跟顺序有关的操作
//		String str = (String) list.get(4);//get的是一个object类型，需要强转
//		System.out.println(str);
//		list.set(1, "abcd");
//		list.remove(0);
//		System.out.println((String)list.get(0));
	}

}

class Dog {
	
}