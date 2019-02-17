package testSort.innerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test04 {

	public static void main(String[] args) {
		Date[] arr = new Date[3];
		arr[0] = new Date();
		arr[1] = new Date(System.currentTimeMillis()-1000*60*60);//һ��Сʱ֮ǰ
		arr[2] = new Date(System.currentTimeMillis()+1000*60*60);//һ��Сʱ֮��
		//����
		UtilsCollections.sort(arr);
		
		//�ַ���
		String[] arr2 = {"a","abcd","abc","def"};
		UtilsCollections.sort(arr2);
		System.out.println("----List����-----");
		
		//���������
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		System.out.println(list);
		UtilsCollections.sort(list);
		System.out.println(list);
		
		System.out.println("-----ʹ��Comparator��������-----");
		arr2 = new String[]{"a","abcd","abc","def"};
		UtilsCollections.sort(arr2, new StringComparator());//������������
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("----List����+�Ƚ���-----");
		 
		list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		System.out.println(list);
		UtilsCollections.sort(list, new StringComparator());
		System.out.println(list);
	}
}
