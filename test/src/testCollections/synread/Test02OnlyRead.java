package testCollections.synread;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * ֻ������
 * emptyXxx()�յĲ��ɱ�ļ��� emptyList() emptyMap() emptySet()
 * singletonXxx()һ��Ԫ�صĲ��ɱ�ļ��� ֻ��һ��Ԫ��
 * unmodifiableXxx()���ɱ�����
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
//		//ֻ������
//		//unmodifiable�����Ĳ���
//		Map<String,String> map2 = Collections.unmodifiableMap(map);
//		
//		map2.put("test8", "test9");//ֻ�� �����޸Ļᱨ��
		
		//ֻ�ܰ���һ��Ԫ�ص������Ĳ���
		List<String> list = Collections.singletonList(new String());
		list.add("test");
		
	}
	
	public static Set<String> oper(Set<String> set){
		
		if(null==set){
			return Collections.EMPTY_SET;
			//�ⲿ��ȡʱ���Ա���NullPointerException �����ô���յ�����
		}
		//����
		return set;
	}
}
