package testIterator;

/**
 * 简化迭代器原理
 * hasNext
 * next
 * @author yinyiliang
 *
 */

public class SxtSimpleList {
	String[] elem = {"a","b","c","d","e","f","g"};
	private int size = elem.length;
	
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
