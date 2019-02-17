package testHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 分拣存储：1对多 1：N
 * 统计单词出现的次数
 * 
 * 
 * 
 * 思路：分割字符串；分拣存储；按要求查看单词出现次数
 * 
 * @author yinyiliang
 *
 */

public class MapTest02 {

	public static void main(String[] args) {
		
		String[] arr ="this is a cat and that is a mat and where is the food?".split(" ");
		
		Map<String, Letter> map = new HashMap<String, Letter>();
		
		for(String key:arr){
			
//			if(!map.containsKey(key)){
//				//检查是否存在 不存在则创建Letter
//				map.put(key, new Letter(key));
//			}
//				//这里Letter(key)是构造器，既创建了对象又将name写为了key
//				Letter value = map.get(key);
//				value.setCount(value.getCount()+1);//初始时value.getCount()是0，每set一次都+1
		
			//以上也可以如下写
			Letter value = map.get(key);
			if(null==value){
				value = new Letter(key);
				map.put(key, value);
			}
			value.setCount(value.getCount()+1);
			
		}
		
		//查看每个单词出现的次数
		for(String key:map.keySet()){
			Letter value = map.get(key);
			System.out.println(value.getName()+"-->"+value.getCount());
//			System.out.println(key+"-->"+value.getCount());
		}
		
	}
}
