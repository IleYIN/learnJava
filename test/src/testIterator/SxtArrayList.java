package testIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 使用泛型，可以操纵多个类型
 * 
 * @author yinyiliang
 *
 */





public class SxtArrayList<E> implements java.lang.Iterable<E> {//为了使用增强for循环

	private Object[] elem = new Object[5];
	private int size = 0;//实际大小
	
	
	public int size(){
		return size;
	}
	
	public void add(E str){
		if(this.size==elem.length){
			elem = Arrays.copyOf(elem, elem.length + 5);//扩容
		}
		elem[size] = str;
		size++;
	}
	
	//内部类
	
	public Iterator<E> iterator(){
		return new Iterator<E>(){//创建Iterator迭代器接口 实现类（没有名称）的对象
		
			private int cursor = -1;
			
			//判断是否存在下一个元素
			public boolean hasNext(){
				return cursor+1 < size;
			}
			
			//获取下一个元素
			public E next(){
				cursor++;
				return (E) elem[cursor];
			//移动一次
			}
			
			//删除元素
			public void remove(){
				System.arraycopy(elem, cursor+1, elem, cursor, SxtArrayList.this.size-(cursor+1));
				SxtArrayList.this.size--;
				this.cursor--;
			}
		};
	}
	
	
	
	public static void main(String[] args) {
		
		SxtArrayList<Integer>  list= new SxtArrayList<Integer>();
		
		list.add(1);//自动装箱int-->Integer
		list.add(2);
		
		for(Integer e:list){
			System.out.println(e);
		}
		
		System.out.println("--------");
		
		
		SxtArrayList<String>  list2= new SxtArrayList<String>();
		
		list2.add("abc");
		list2.add("ABC");
		list2.add("啊啊啊");
		list2.add("哈哈哈");
		
//		for(String e:list2){
//			System.out.println(e);
//		}
		Iterator<String> it = list2.iterator();
		while (it.hasNext()) {
			String e = it.next();
			System.out.println(e);
		}
		
	}
}
