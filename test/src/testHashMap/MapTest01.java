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

public class MapTest01 {

	public static void main(String[] args) {
		
		String[] arr ="this is a cat and that is a mat and where is the food?".split(" ");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String key:arr){
//			System.out.println(key);//打印每个单词
			
//			if (!map.containsKey(key)){//查看一开始有没有存这个单词
//				map.put(key, 1);
//			}else{//已经存在
//				map.put(key, map.get(key)+1);
//			}
			
			//以上也可以改成下面的
			Integer value =map.get(key);
			if (null==value){
				map.put(key, 1);
			}else{
				map.put(key, value+1);
			}

		
		}
		//查看每个单词出现的次数
		Set<String> keySet = map.keySet();
		//使用迭代器或增强for循环
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"-->"+value);
		}
	}
}
