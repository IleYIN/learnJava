package testCollections.threeHashMap;

import java.util.IdentityHashMap;

/**
 * 
 * ���Ƚϵ�ַȥ��
 * @author yinyiliang
 *
 */
public class IdentityHashMapTest {

	public static void main(String[] args) {
		IdentityHashMap<String, String> map = new IdentityHashMap<String, String>();
		
		//key "a" �ǳ������е�
		map.put("a", "a1");
		map.put("a", "a2");
		System.out.println(map.size());
		
		map.put(new String("a"), "a3");//�¶����ǲ�ͬ�ĵ�ַ
		map.put(new String("a"), "a4");//�¶����ǲ�ͬ�ĵ�ַ
		System.out.println(map.size());
		
	}
}
