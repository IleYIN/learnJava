package testGuava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap��Ψһ��ֵ�����ظ�
 * BiMap��˫��Map(Bidirectional Map) ����ֵ�������ظ�(unique -valued map)
 * ��������
 * 
 * @author yinyiliang
 *
 */
public class Test07Bimap {

	public static void main(String[] args) {
		
		BiMap<String,String> bimap = HashBiMap.create();
		bimap.put("bjsxt", "bjsxt@sina.com");
		bimap.put("good", "good@qq.com");
		
		//ͨ���������û�
		String user = bimap.inverse().get("good@qq.com");
		System.out.println(user);
		System.out.println(bimap.inverse().inverse()==bimap);
	}
}