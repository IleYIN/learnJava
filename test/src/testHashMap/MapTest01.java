package testHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * �ּ�洢��1�Զ� 1��N
 * ͳ�Ƶ��ʳ��ֵĴ���
 * 
 * 
 * 
 * ˼·���ָ��ַ������ּ�洢����Ҫ��鿴���ʳ��ִ���
 * 
 * @author yinyiliang
 *
 */

public class MapTest01 {

	public static void main(String[] args) {
		
		String[] arr ="this is a cat and that is a mat and where is the food?".split(" ");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String key:arr){
//			System.out.println(key);//��ӡÿ������
			
//			if (!map.containsKey(key)){//�鿴һ��ʼ��û�д��������
//				map.put(key, 1);
//			}else{//�Ѿ�����
//				map.put(key, map.get(key)+1);
//			}
			
			//����Ҳ���Ըĳ������
			Integer value =map.get(key);
			if (null==value){
				map.put(key, 1);
			}else{
				map.put(key, value+1);
			}

		
		}
		//�鿴ÿ�����ʳ��ֵĴ���
		Set<String> keySet = map.keySet();
		//ʹ�õ���������ǿforѭ��
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"-->"+value);
		}
	}
}
