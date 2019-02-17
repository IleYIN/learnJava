package testSort.innerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections对容器的比较
 * 
 * public static <T> void sort (List<T> list, Comparator<? super T> c)
 * 
 * 实体类
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
		//指定比较器Comparator 业务类 java.util.Comparator+compare
		Collections.sort(list, new StringComparator());
		//可以把StringComparator里的return取相反数即可变成降序
		
		System.out.println(list);
		
		
		list = new ArrayList<String>();
		list.add("a");
		list.add("abcd");
		list.add("abc");
		list.add("def");
		System.out.println(list);
		//默认比较器Comparable 实体类java.lang.Comparable+compareTo
		Collections.sort(list);
		System.out.println(list);
		
	}
}
