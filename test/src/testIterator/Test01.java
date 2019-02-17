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
		
		//通过索引遍历list
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		//通过迭代器遍历list
		for (Iterator iter2 = list.iterator();iter2.hasNext();){
			//或者用for，不用写for的最后一项因为iter.next就够了
			String str = (String) iter2.next();
			System.out.println(str);
			iter2.remove();
		}
		System.out.println(list.size()+"*****");//得到0，因为remove()删掉了对象
		
		Set set = new HashSet();
		//set没有顺序所以不能用for循环来迭代,只能用迭代器
		set.add("AAA");
		set.add("BBB");
		set.add("CCC");
		
		
		//通过迭代器遍历set
//		Iterator iter = set.iterator();
//		while(iter.hasNext()){
		for (Iterator iter = set.iterator();iter.hasNext();){
			//或者用for，不用写for的最后一项因为iter.next就够了
			String str = (String) iter.next();
			System.out.println(str);
		}
	}
}
