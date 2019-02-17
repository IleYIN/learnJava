package testSort.innerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test04 {

	public static void main(String[] args) {
		Date[] arr = new Date[3];
		arr[0] = new Date();
		arr[1] = new Date(System.currentTimeMillis()-1000*60*60);//一个小时之前
		arr[2] = new Date(System.currentTimeMillis()+1000*60*60);//一个小时之后
		//降序
		UtilsCollections.sort(arr);
		
		//字符串
		String[] arr2 = {"a","abcd","abc","def"};
		UtilsCollections.sort(arr2);
		System.out.println("----List排序-----");
		
		//存放容器中
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		System.out.println(list);
		UtilsCollections.sort(list);
		System.out.println(list);
		
		System.out.println("-----使用Comparator排序数组-----");
		arr2 = new String[]{"a","abcd","abc","def"};
		UtilsCollections.sort(arr2, new StringComparator());//按长度来降序
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("----List排序+比较器-----");
		 
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
