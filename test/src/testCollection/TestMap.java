package testCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * ����Map�Ļ����÷�
 * @author yinyiliang
 *
 */
public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();//HashMap�̲߳���ȫ��Hashtable�̰߳�ȫЧ�ʵ�
		map.put("С��", new Wife("Сӣ"));//keyҲ�Ƕ���
		map.put("����", new Wife("����"));
//		map.put("����", new Wife("����")); ��ֵ�����ظ�����Ȼ�Ḳ�ǵ�ԭ����
		
//		map.remove("����");
		Wife w = (Wife) map.get("����");
		System.out.println(w.name);
		System.out.println(map.containsKey("С��"));
	}
}

class Wife{
	String name;
	public Wife(String name){
		this.name = name;
	}
}