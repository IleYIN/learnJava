package testGeneric;

/**
 * û�з������飬���ܴ�����������Ҳ���ǲ��ܿ��ٿռ�
 * �ڲ���Objectǿת��E
 * ��������  ������?
 * @author yinyiliang
 *
 */
public class Array {
	public static void main(String[] args) {
		Integer[] arr = new Integer[4];
//		StudentWenhao<String>[] arr2 = new StudentWenhao<String>[10];
//		���ܴ�����������,������������д����û������
		StudentWenhao<String>[] arr2 = new StudentWenhao[10];
		StudentWenhao<?>[] arr3 = new StudentWenhao[10];
		
		MyArrayList<String> strList = new MyArrayList<String>();
		strList.add(0, "a");
		System.out.println(strList.getElem(0));
	}
}

class MyArrayList<E>{
	
//	E[] ele = new E[10]; ����
//	E[] ele2 = new Object[10];���� û�з�������
	
	
	//Object���Խ�����������
	Object[] cap = new Object[10];
	
	public void add(int index, E e){
		cap[index] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E[] getAll(){
		return (E[]) cap;
	}
	
	@SuppressWarnings("unchecked")
	public E getElem(int index){
		return (E) cap[index];
	}
}