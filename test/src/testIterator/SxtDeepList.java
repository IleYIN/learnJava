package testIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 深入迭代器原理
 * 一个容器可以创建多个迭代器对象
 * 使用了内部类 匿名内部类 实现迭代器
 * 
 * 使用Iterables实现foreach
 * 
 * 末尾加元素add
 * 
 * 
 * @author yinyiliang
 *
 */

public class SxtDeepList implements java.lang.Iterable {//为了使用增强for循环
//	String[] elem = {"a","b","c","d","e","f","g"};
	private String[] elem = new String[5];
//	private int size = elem.length;
	private int size = 0;//实际大小
	
	
	public int size(){
		return size;
	}
	
	public void add(String str){
		if(this.size==elem.length){
			elem = Arrays.copyOf(elem, elem.length + 5);//扩容
		}
		elem[size] = str;
		size++;
	}
	
	//内部类
	private class MyIterator implements Iterator {
		private int cursor = -1;
		
		//判断是否存在下一个元素
		public boolean hasNext(){
			return cursor+1 < size;
		}
		
		//获取下一个元素
		public String next(){
			cursor++;
			return elem[cursor];
		//移动一次
		}
		
		//删除元素
		public void remove(){
			System.arraycopy(elem, cursor+1, elem, cursor, SxtDeepList.this.size-(cursor+1));
			SxtDeepList.this.size--;
			this.cursor--;
		}
	}
	
	public Iterator iterator(){
		return new MyIterator();
	}

	
	
	public Iterator iterator2(){
		
		//内部类移动到方法里面去
		class MyIterator2 implements Iterator {
			private int cursor = -1;
			
			//判断是否存在下一个元素
			public boolean hasNext(){
				return cursor+1 < size;
			}
			
			//获取下一个元素
			public String next(){
				cursor++;
				return elem[cursor];
			//移动一次
			}
			
			//删除元素
			public void remove(){
				System.arraycopy(elem, cursor+1, elem, cursor, SxtDeepList.this.size-(cursor+1));
				SxtDeepList.this.size--;
				this.cursor--;
			}
		}
		return new MyIterator2();
	}

	
	
	public Iterator iterator3(){
		return new Iterator(){//创建Iterator迭代器接口 实现类（没有名称）的对象
		
			private int cursor = -1;
			
			//判断是否存在下一个元素
			public boolean hasNext(){
				return cursor+1 < size;
			}
			
			//获取下一个元素
			public String next(){
				cursor++;
				return elem[cursor];
			//移动一次
			}
			
			//删除元素
			public void remove(){
				System.arraycopy(elem, cursor+1, elem, cursor, SxtDeepList.this.size-(cursor+1));
				SxtDeepList.this.size--;
				this.cursor--;
			}
		};
	}
	
	
	
	public static void main(String[] args) {
		SxtDeepList list = new SxtDeepList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c1");
		list.add("c2");
		list.add("c3");
		list.add("c4");
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
//			it.remove();
		}
		System.out.println(list.size());
		
		for(Object str:list){
			//增强for循环，只能是java.lang.Iterable
			//没加泛型， 是Object
			System.out.println(str);
		}
		
//		System.out.println("----------");
//		
//		//Iterator内部类作用，只需要创建迭代器对象不需要创建容器
//		Iterator it2 = list.iterator2();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//		}
//		System.out.println("----------");
//		
//		//Iterator内部类作用，只需要创建迭代器对象不需要创建容器
//		Iterator it3 = list.iterator3();
//		while(it3.hasNext()){
//			System.out.println(it3.next());
//		}
//		
		System.out.println("----------");

		
		
		ArrayList list2 = new ArrayList();
		
		list2.add("a");
		list2.add("a");
		list2.add("a");
		list2.add("a");
		
		for(Object obj:list2){//foreach
			System.out.println(obj);
		}
	}
}
