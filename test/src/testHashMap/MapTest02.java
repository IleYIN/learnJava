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

public class MapTest02 {

	public static void main(String[] args) {
		
		String[] arr ="this is a cat and that is a mat and where is the food?".split(" ");
		
		Map<String, Letter> map = new HashMap<String, Letter>();
		
		for(String key:arr){
			
//			if(!map.containsKey(key)){
//				//����Ƿ���� �������򴴽�Letter
//				map.put(key, new Letter(key));
//			}
//				//����Letter(key)�ǹ��������ȴ����˶����ֽ�nameдΪ��key
//				Letter value = map.get(key);
//				value.setCount(value.getCount()+1);//��ʼʱvalue.getCount()��0��ÿsetһ�ζ�+1
		
			//����Ҳ��������д
			Letter value = map.get(key);
			if(null==value){
				value = new Letter(key);
				map.put(key, value);
			}
			value.setCount(value.getCount()+1);
			
		}
		
		//�鿴ÿ�����ʳ��ֵĴ���
		for(String key:map.keySet()){
			Letter value = map.get(key);
			System.out.println(value.getName()+"-->"+value.getCount());
//			System.out.println(key+"-->"+value.getCount());
		}
		
	}
}
