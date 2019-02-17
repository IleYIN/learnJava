package testCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map的基本用法
 * @author yinyiliang
 *
 */
public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();//HashMap线程不安全，Hashtable线程安全效率低
		map.put("小明", new Wife("小樱"));//key也是对象
		map.put("张三", new Wife("李四"));
//		map.put("张三", new Wife("李三")); 键值不能重复，不然会覆盖掉原来的
		
//		map.remove("张三");
		Wife w = (Wife) map.get("张三");
		System.out.println(w.name);
		System.out.println(map.containsKey("小明"));
	}
}

class Wife{
	String name;
	public Wife(String name){
		this.name = name;
	}
}