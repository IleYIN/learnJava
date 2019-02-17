package testSort.innerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ʹ��Collections�������ıȽ�
 * 
 * public static <T> void sort (List<T> list, Comparator<? super T> c)
 * 
 * ʵ����
 * public static <T extends Comparable<? super T>> void sort(List<T> list) void sort(List<T> list)
 * 
 * @author yinyiliang
 *
 */
public class Test05 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		System.out.println(list);
		//ָ���Ƚ���Comparator ҵ���� java.util.Comparator+compare
		Collections.sort(list, new StringComparator());
		//���԰�StringComparator���returnȡ�෴�����ɱ�ɽ���
		
		System.out.println(list);
		
		
		list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		System.out.println(list);
		//Ĭ�ϱȽ���Comparable ʵ����java.lang.Comparable+compareTo
		Collections.sort(list);
		System.out.println(list);
		
	}
}
