package testCollections.threeHashMap;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱类型  gc运行立即回收
 * @author yinyiliang
 *
 */
public class WeakHashMapTest {

	public static void main(String[] args) {
		
		WeakHashMap<String, String> map = new WeakHashMap<String, String>();
		//测试数据
		map.put("abc", "A");
		map.put("d", "TEST");
		map.put(new String("efghi"), "C");
		map.put(new String("jklmn"), "D");
		
		//通知回收
		System.gc();
		System.runFinalization();//弱引用管理运行垃圾回收机制就会回收非共享对象
		
		System.out.println(map.size());
		//常量池对象不会回收       new出来的对象使用WeakHashMap在gc运行时会被回收
	}
}
