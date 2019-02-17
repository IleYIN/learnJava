package testGuava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 分析查看教师教授的每门课程
 * Multimap: key-value  key可以重复
 * 
 * 使用增强for循环来遍历 或者用Iterator
 * 
 * @author yinyiliang
 *
 */
public interface Test06Multimap {

	public static void main(String[] args) {
		
		Map<String,String> cours = new HashMap<String,String>();
		cours.put("改革开放","邓小平");
		cours.put("三个代表","江泽民");
		cours.put("科学发展观","胡锦涛");
		cours.put("和谐社会","胡锦涛");
		cours.put("八荣八耻","胡锦涛");
		cours.put("拭目以待","习近平");
		
		//Multimap
		Multimap<String,String> teachers = ArrayListMultimap.create();
		
		//使用增强for循环来遍历 或者用Iterator
		//迭代器
		Iterator<Map.Entry<String,String>> it = cours.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			
			teachers.put(value,key);//cours的value作为teachers的key;cours的key作为teachers的value
			
		}
		
		//查看Multimap
		//使用增强for循环来遍历 或者用Iterator
		Set<String> keyset = teachers.keySet();
//		或使用 Set<String> keyset = teachers.keys().elementSet();
		
		for(String key:keyset){
			System.out.println(key+"-->"+teachers.get(key));
		}
	}
}
