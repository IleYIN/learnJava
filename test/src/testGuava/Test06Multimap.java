package testGuava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * �����鿴��ʦ���ڵ�ÿ�ſγ�
 * Multimap: key-value  key�����ظ�
 * 
 * ʹ����ǿforѭ�������� ������Iterator
 * 
 * @author yinyiliang
 *
 */
public interface Test06Multimap {

	public static void main(String[] args) {
		
		Map<String,String> cours = new HashMap<String,String>();
		cours.put("�ĸ￪��","��Сƽ");
		cours.put("��������","������");
		cours.put("��ѧ��չ��","������");
		cours.put("��г���","������");
		cours.put("���ٰ˳�","������");
		cours.put("��Ŀ�Դ�","ϰ��ƽ");
		
		//Multimap
		Multimap<String,String> teachers = ArrayListMultimap.create();
		
		//ʹ����ǿforѭ�������� ������Iterator
		//������
		Iterator<Map.Entry<String,String>> it = cours.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			
			teachers.put(value,key);//cours��value��Ϊteachers��key;cours��key��Ϊteachers��value
			
		}
		
		//�鿴Multimap
		//ʹ����ǿforѭ�������� ������Iterator
		Set<String> keyset = teachers.keySet();
//		��ʹ�� Set<String> keyset = teachers.keys().elementSet();
		
		for(String key:keyset){
			System.out.println(key+"-->"+teachers.get(key));
		}
	}
}
