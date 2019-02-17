package testIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * ���������ԭ��
 * һ���������Դ����������������
 * ʹ�����ڲ��� �����ڲ��� ʵ�ֵ�����
 * 
 * ʹ��Iterablesʵ��foreach
 * 
 * ĩβ��Ԫ��add
 * 
 * 
 * @author yinyiliang
 *
 */

public class SxtDeepList implements java.lang.Iterable {//Ϊ��ʹ����ǿforѭ��
//	String[] elem = {"a","b","c","d","e","f","g"};
	private String[] elem = new String[5];
//	private int size = elem.length;
	private int size = 0;//ʵ�ʴ�С
	
	
	public int size(){
		return size;
	}
	
	public void add(String str){
		if(this.size==elem.length){
			elem = Arrays.copyOf(elem, elem.length + 5);//����
		}
		elem[size] = str;
		size++;
	}
	
	//�ڲ���
	private class MyIterator implements Iterator {
		private int cursor = -1;
		
		//�ж��Ƿ������һ��Ԫ��
		public boolean hasNext(){
			return cursor+1 < size;
		}
		
		//��ȡ��һ��Ԫ��
		public String next(){
			cursor++;
			return elem[cursor];
		//�ƶ�һ��
		}
		
		//ɾ��Ԫ��
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
		
		//�ڲ����ƶ�����������ȥ
		class MyIterator2 implements Iterator {
			private int cursor = -1;
			
			//�ж��Ƿ������һ��Ԫ��
			public boolean hasNext(){
				return cursor+1 < size;
			}
			
			//��ȡ��һ��Ԫ��
			public String next(){
				cursor++;
				return elem[cursor];
			//�ƶ�һ��
			}
			
			//ɾ��Ԫ��
			public void remove(){
				System.arraycopy(elem, cursor+1, elem, cursor, SxtDeepList.this.size-(cursor+1));
				SxtDeepList.this.size--;
				this.cursor--;
			}
		}
		return new MyIterator2();
	}

	
	
	public Iterator iterator3(){
		return new Iterator(){//����Iterator�������ӿ� ʵ���ࣨû�����ƣ��Ķ���
		
			private int cursor = -1;
			
			//�ж��Ƿ������һ��Ԫ��
			public boolean hasNext(){
				return cursor+1 < size;
			}
			
			//��ȡ��һ��Ԫ��
			public String next(){
				cursor++;
				return elem[cursor];
			//�ƶ�һ��
			}
			
			//ɾ��Ԫ��
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
			//��ǿforѭ����ֻ����java.lang.Iterable
			//û�ӷ��ͣ� ��Object
			System.out.println(str);
		}
		
//		System.out.println("----------");
//		
//		//Iterator�ڲ������ã�ֻ��Ҫ����������������Ҫ��������
//		Iterator it2 = list.iterator2();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//		}
//		System.out.println("----------");
//		
//		//Iterator�ڲ������ã�ֻ��Ҫ����������������Ҫ��������
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
