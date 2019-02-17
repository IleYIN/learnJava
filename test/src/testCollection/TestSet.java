package testCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试Set的常用方法
 * 
 * @author yinyiliang
 *
 */
public class TestSet {
	public static void main(String[] args) {
		
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new String("aaa"));
//		set.remove("aaa");
//		set.clear();
		System.out.println(set.size());//set里没有get因为没有顺序
		//虽然不是同一个对象，但equals是true的，所以会覆盖，set源码里和map有关，map的key不能重复
		
		System.out.println(set.contains("aaa"));
	}
}
