package testIterator;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		//ͨ����������list
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		//ͨ������������list
		for (Iterator iter2 = list.iterator();iter2.hasNext();){
			//������for������дfor�����һ����Ϊiter.next�͹���
			String str = (String) iter2.next();
			System.out.println(str);
			iter2.remove();
		}
		System.out.println(list.size()+"*****");//�õ�0����Ϊremove()ɾ���˶���
		
		Set set = new HashSet();
		//setû��˳�����Բ�����forѭ��������,ֻ���õ�����
		set.add("AAA");
		set.add("BBB");
		set.add("CCC");
		
		
		//ͨ������������set
//		Iterator iter = set.iterator();
//		while(iter.hasNext()){
		for (Iterator iter = set.iterator();iter.hasNext();){
			//������for������дfor�����һ����Ϊiter.next�͹���
			String str = (String) iter.next();
			System.out.println(str);
		}
	}
}
