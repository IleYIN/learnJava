package testCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCollection01 {
	
	public static void main(String[] args){
		List list = new ArrayList();
//		List list = new LinkedList(); 
//ArrayList�ײ�ʵ�������飬��ѯ�ٶȺܿ�����޸�ɾ����
//LinkedList�ײ�ʵ������������ǰ�������ڵ��λ�ú͵�ǰ�ڵ��ֵ�������������޸�ɾ����
//Vector:�̰߳�ȫ�ģ�Ч�ʵͣ����������̲߳���ȫ����Ч�ʸ�	
		
//		Collection list = new ArrayList();//Ҳ����Collection������û�к�˳����صĲ���
		
		
		list.add("aaa"); //��Ӷ���
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);//��װ��ģ��Զ�װ���Integer
		list.add("aaa");
		
		System.out.println(list.size());//��ʾ����Ԫ�صĳ��ȶ���������ĳ���
//		System.out.println(list.isEmpty());
//		list.remove(new Date());//���ܺ������Date���������󣬻������Ƴ�ȥ����hashcode��equals�ж�����й�
		list.remove(new String("aaa"));//������ɾ������Ϊ�ײ��е�remove�õ���equals�Ƚϵ���ֵ������ɾ��һ����return�ˣ����Բ���ɾ����һ����aaa��
		System.out.println(list.size());
		
		for (int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		
//		List list2 = new ArrayList();
//		list2.add("bbb");
//		list2.add("ccc");
//		list2.add("eee");
//		
//		list.addAll(list2);
//		System.out.println(list.size());
//		System.out.println(list2.size());
//		
//		//��˳���йصĲ���
//		String str = (String) list.get(4);//get����һ��object���ͣ���Ҫǿת
//		System.out.println(str);
//		list.set(1, "abcd");
//		list.remove(0);
//		System.out.println((String)list.get(0));
	}

}

class Dog {
	
}