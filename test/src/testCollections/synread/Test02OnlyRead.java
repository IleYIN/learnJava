package testCollections.synread;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 只读设置
 * emptyXxx()空的不可变的集合 emptyList() emptyMap() emptySet()
 * singletonXxx()一个元素的不可变的集合 只含一个元素
 * unmodifiableXxx()不可变容器
 * 
 * @author yinyiliang
 *
 */
public class Test02OnlyRead {

	public static void main(String[] args) {
		
//		Map<String,String> map = new HashMap<String,String>();
//		
//		map.put("test","test2");
//		map.put("test3","test4");
//		
//		//只读控制
//		//unmodifiable容器的测试
//		Map<String,String> map2 = Collections.unmodifiableMap(map);
//		
//		map2.put("test8", "test9");//只读 不能修改会报错
		
		//只能包含一个元素的容器的测试
		List<String> list = Collections.singletonList(new String());
		list.add("test");
		
	}
	
	public static Set<String> oper(Set<String> set){
		
		if(null==set){
			return Collections.EMPTY_SET;
			//外部获取时可以避免NullPointerException 而不用处理空的问题
		}
		//操作
		return set;
	}
}
