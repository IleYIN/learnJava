package testCollection;

import java.util.HashMap;

public class SxtHashSet {
	
	HashMap map;//������Ŷ���Ԫ����Ϣ��
	//����Ԫ�ض�����map���key����ţ�key�����ظ���value���ظ�
	private static final Object PRESENT = new Object();//value��һ������
	
	public SxtHashSet(){
		map = new HashMap();
	}
	
	public int size(){
		return map.size();//ֱ������map���size���ɲ����Լ�����
	}
	
	public void add(Object o){
		map.put(o, PRESENT);//set�Ĳ����ظ�����������map���������Ĳ����ظ�
	}
	
	public static void main(String[] args) {
		SxtHashSet s = new SxtHashSet();
		s.add("aaa");
		s.add(new String("aaa"));
		System.out.println(s.size());
	}
}
