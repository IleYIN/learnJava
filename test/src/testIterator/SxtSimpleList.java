package testIterator;

/**
 * �򻯵�����ԭ��
 * hasNext
 * next
 * @author yinyiliang
 *
 */

public class SxtSimpleList {
	String[] elem = {"a","b","c","d","e","f","g"};
	private int size = elem.length;
	
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
		System.arraycopy(elem, cursor+1, elem, cursor, this.size-(cursor+1));
		this.size--;
		this.cursor--;
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		SxtSimpleList list = new SxtSimpleList();
		if(list.hasNext()){
			System.out.println(list.next());
		}
		if(list.hasNext()){
			System.out.println(list.next());
			list.remove();
		}
		if(list.hasNext()){
			System.out.println(list.next());
		}
		if(list.hasNext()){
			System.out.println(list.next());
		}
		if(list.hasNext()){
			System.out.println(list.size());
		}
	}
}
