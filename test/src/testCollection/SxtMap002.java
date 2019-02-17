package testCollection;

import java.util.LinkedList;

/**
 * �Զ���Map��������
 * ��߲�ѯЧ�ʱ���ѭ������
 * 
 * @author yinyiliang
 *
 */
public class SxtMap002 {

	LinkedList[] arr = new LinkedList[999];
	//SxtLinkedList[]�����飬SxtLinkedList��֮ǰ���õ������࣬�����������������˴�����������������
	//Map�ĵײ�ṹ��������+����
	int size;
	
	public void put(Object key, Object value){
		SxtEntry e = new SxtEntry(key,value);
		
		//�е�ʱ��hashCode���ص��Ǹ�ֵ����ֵȡ�����ܻ��Ǹ�����������Ҫ�Ľ�
		int hash = key.hashCode();
		hash = hash<0 ? -hash : hash;
		
		int a = hash%arr.length;
		//hashCode�Ǹ��ݵ�ַ���ɵ�hash��
		//1000-->1  10000-->10  �׶��������п����ظ������Խ���ͬ�����ķ�һ��������
		if (arr[a]==null){
			LinkedList list = new LinkedList();
			arr[a] = list;
			//SxtLinkedList()���������
			list.add(e);
		} else {
			
			//�ж��ǲ������ظ���key�����и���
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				SxtEntry e2 = (SxtEntry) list.get(i);
				if (e2.key.equals(key)){
					e2.value = value; //���ظ�ֱ�Ӹ���
					return;
				}
			}
			//��û���ظ���ֱ�ӷŽ�ȥ
			arr[a].add(e);
		}
	}
	
	public Object get(Object key){
//		return arr[key.hashCode()%999];
		int a = key.hashCode()%arr.length;
		if (arr[a]!=null){
			LinkedList list = arr[a];
			//SxtLinkedList()���������, ��������б�
			for (int i = 0; i < list.size(); i++) {
				SxtEntry e = (SxtEntry) list.get(i);
				if (e.key.equals(key)){
					return e.value;
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		SxtMap002 m = new SxtMap002();
		m.put("����", new Wife("����������"));
		m.put("����", new Wife("���ĵ�����"));
		m.put("����", new Wife("���ĵĶ�������"));
		Wife w = (Wife)m.get("����");
		System.out.println(w.name);
	}
	
	
}
