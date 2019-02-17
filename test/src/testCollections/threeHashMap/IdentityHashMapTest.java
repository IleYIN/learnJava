package testCollections.threeHashMap;

import java.util.IdentityHashMap;

/**
 * 
 * 键比较地址去重
 * @author yinyiliang
 *
 */
public class IdentityHashMapTest {

	public static void main(String[] args) {
		IdentityHashMap<String, String> map = new IdentityHashMap<String, String>();
		
		//key "a" 是常量池中的
		map.put("a", "a1");
		map.put("a", "a2");
		System.out.println(map.size());
		
		map.put(new String("a"), "a3");//新对象是不同的地址
		map.put(new String("a"), "a4");//新对象是不同的地址
		System.out.println(map.size());
		
	}
}
