package testCommons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 迭代器的扩展
 * 1、MapIterator  以后不用再用map.keySet.iterator访问
 * 		IterableMap  HashedMap
 * 2、UniqueFilterIterator 去重迭代器
 * 		UniqueFilterIterator(list.iterator())
 * 3、自定义过滤器 +Predicate    
 * 			FilterIterator(list.iterator(),predicate)
 * 4、循环迭代器 LoopingIterator
 * 5、数组迭代器ArrayListIterator
 * 
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test06Iterator {

	public static void main(String[] args) {
//		mapIt();
//		uniqueIt();
//		filterIt();		
//		loopIt();
		arrayIt();
	}
	
	
	public static void mapIt(){
		
		System.out.println("------mapIterator------");
		
		IterableMap<String, String> map = new HashedMap<String, String>();
		map.put("a", "AAAA");
		map.put("b", "BBBB");
		map.put("c", "CCCC");
		
		//使用MapIterator
		MapIterator<String,String> it = map.mapIterator();
		while(it.hasNext()){
			
			//it.next();移动游标
			//String key = it.getkey();
			//或下面写法
			String key = it.next();
			String value = it.getValue();
			System.out.println(key+"-->"+value);
		}
	}
	
	public static void uniqueIt(){
		
		System.out.println("-------UniqueFilterIterator-------");
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("c");
		
		//去重过滤器
		Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	
	public static void filterIt(){
		
		System.out.println("--------自定义过滤器-------");
		List<String> list = new ArrayList<String>();
		list.add("mom");
		list.add("dad");
		list.add("lalala");
		list.add("moon");
		
		//自定义条件判断
		Predicate<String> pre = new Predicate<String>(){

			@Override
			public boolean evaluate(String str) {
				//回文判断
				return new StringBuilder(str).reverse().toString().equals(str);
			}
		};
		
		//过滤器
		Iterator<String> it = new FilterIterator(list.iterator(),pre);//连接自定义条件
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
	
	public static void loopIt(){
		
		System.out.println("-----循环迭代器-----");
		
		List<String> list = new ArrayList<String>();
		list.add("mom");
		list.add("dad");
		list.add("lalala");
		list.add("moon");
		
		Iterator<String> it = new LoopingIterator(list);
		for(int i=0; i<15; i++){
//		while(it.hasNext()){ //若用while会一直循环打印
			System.out.println(it.next());
		}
	}
	
	
	public static void arrayIt(){
		
		System.out.println("-------数组迭代器------");
		
		int[] arr = {1,2,3,4,5};
		//数组迭代器
//		Iterator<Integer> it = new ArrayListIterator<Integer>(arr);
		
		//指定起始索引和结束索引
		Iterator<Integer> it = new ArrayListIterator<Integer>(arr,1,3);
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
}
