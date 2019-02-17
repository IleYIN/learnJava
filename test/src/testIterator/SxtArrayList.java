package testIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * ʹ�÷��ͣ����Բ��ݶ������
 * 
 * @author yinyiliang
 *
 */





public class SxtArrayList<E> implements java.lang.Iterable<E> {//Ϊ��ʹ����ǿforѭ��

	private Object[] elem = new Object[5];
	private int size = 0;//ʵ�ʴ�С
	
	
	public int size(){
		return size;
	}
	
	public void add(E str){
		if(this.size==elem.length){
			elem = Arrays.copyOf(elem, elem.length + 5);//����
		}
		elem[size] = str;
		size++;
	}
	
	//�ڲ���
	
	public Iterator<E> iterator(){
		return new Iterator<E>(){//����Iterator�������ӿ� ʵ���ࣨû�����ƣ��Ķ���
		
			private int cursor = -1;
			
			//�ж��Ƿ������һ��Ԫ��
			public boolean hasNext(){
				return cursor+1 < size;
			}
			
			//��ȡ��һ��Ԫ��
			public E next(){
				cursor++;
				return (E) elem[cursor];
			//�ƶ�һ��
			}
			
			//ɾ��Ԫ��
			public void remove(){
				System.arraycopy(elem, cursor+1, elem, cursor, SxtArrayList.this.size-(cursor+1));
				SxtArrayList.this.size--;
				this.cursor--;
			}
		};
	}
	
	
	
	public static void main(String[] args) {
		
		SxtArrayList<Integer>  list= new SxtArrayList<Integer>();
		
		list.add(1);//�Զ�װ��int-->Integer
		list.add(2);
		
		for(Integer e:list){
			System.out.println(e);
		}
		
		System.out.println("--------");
		
		
		SxtArrayList<String>  list2= new SxtArrayList<String>();
		
		list2.add("abc");
		list2.add("ABC");
		list2.add("������");
		list2.add("������");
		
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
