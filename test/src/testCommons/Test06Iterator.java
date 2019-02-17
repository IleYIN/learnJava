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
 * ����������չ
 * 1��MapIterator  �Ժ�������map.keySet.iterator����
 * 		IterableMap  HashedMap
 * 2��UniqueFilterIterator ȥ�ص�����
 * 		UniqueFilterIterator(list.iterator())
 * 3���Զ�������� +Predicate    
 * 			FilterIterator(list.iterator(),predicate)
 * 4��ѭ�������� LoopingIterator
 * 5�����������ArrayListIterator
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
		
		//ʹ��MapIterator
		MapIterator<String,String> it = map.mapIterator();
		while(it.hasNext()){
			
			//it.next();�ƶ��α�
			//String key = it.getkey();
			//������д��
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
		
		//ȥ�ع�����
		Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	
	public static void filterIt(){
		
		System.out.println("--------�Զ��������-------");
		List<String> list = new ArrayList<String>();
		list.add("mom");
		list.add("dad");
		list.add("lalala");
		list.add("moon");
		
		//�Զ��������ж�
		Predicate<String> pre = new Predicate<String>(){

			@Override
			public boolean evaluate(String str) {
				//�����ж�
				return new StringBuilder(str).reverse().toString().equals(str);
			}
		};
		
		//������
		Iterator<String> it = new FilterIterator(list.iterator(),pre);//�����Զ�������
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
	
	public static void loopIt(){
		
		System.out.println("-----ѭ��������-----");
		
		List<String> list = new ArrayList<String>();
		list.add("mom");
		list.add("dad");
		list.add("lalala");
		list.add("moon");
		
		Iterator<String> it = new LoopingIterator(list);
		for(int i=0; i<15; i++){
//		while(it.hasNext()){ //����while��һֱѭ����ӡ
			System.out.println(it.next());
		}
	}
	
	
	public static void arrayIt(){
		
		System.out.println("-------���������------");
		
		int[] arr = {1,2,3,4,5};
		//���������
//		Iterator<Integer> it = new ArrayListIterator<Integer>(arr);
		
		//ָ����ʼ�����ͽ�������
		Iterator<Integer> it = new ArrayListIterator<Integer>(arr,1,3);
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
}
