package testCollection;

public class SxtLinkedList /*implements List */{
	private Node first;
	private Node last;
	
	private int size;
	
	public void add(Object obj) {
		Node n = new Node();
		if (first==null){
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			
			first = n;
			last = n;//因为就只有这么一个节点 既是first也是last
		} else {
			//first不是空说明有节点存在，直接在最后一个节点末尾last后面加
			n.setPrevious(last);//该节点的previous是之前的最后一个节点
			n.setObj(obj);
			n.setNext(null);
			
			last.setNext(n);//之前的最后一个节点的next不再是null而是新增的该节点n
			
			last = n;
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public Node node(int index){
		Node temp = null;
		if (first != null) {
			//遍历链表 0 1 2 3 4 直到index
		
			//可以index和size/2即size>>1以为,来比较而不是遍历，效率会更快
			if (index < (size >> 1)){
				temp = first;
				for(int i=0; i<index; i++){
					temp = temp.next;
				}
			}else{
				temp = last;
				for(int i=size-1; i>index; i--){
					temp = temp.previous;
				}
			}
		
		
		}
		return temp;
	}
	
	public Object get(int index){ //2
		//index越界如何处理
		rangeCheck(index);
		return node(index).obj;
	}
	
	public void remove(int index){
		Node temp = null;
		temp = node(index);
		if (temp != null){
			
			if (temp != first && temp != last){
				Node up = temp.previous;
				Node down = temp.next;
				up.next = down;
				down.previous = up;
//			temp.previous.next = temp.next;
//			temp.next.previous = temp.previous;
			}
			
			else if (temp == first){
				Node down = temp.next;
				down.previous = null;
				first = down;
			}
			
			else if (temp == last){
				Node up = temp.previous;
				up.next = null;
				last = up;
			}
			
			size--;
		}
	}
	
	public void add(int index, Object obj){
		rangeCheck(index);
		//创建新节点
		Node newNode = new Node();
		//找位置
		Node temp = node(index);
		if (temp != null){
			Node up = temp.previous;
			up.next = newNode;
			Node down = temp;
			down.previous = newNode;
			
			newNode.obj = obj;
			newNode.previous = up;
			newNode.next = down;
			
			size++;
		}
	}
	
	public void set(int index, Object obj){
		rangeCheck(index);
		//找位置
		Node temp = node(index);
		if (temp != null){
			temp.obj = obj;
		}
	}
	
	
	private void rangeCheck(int index){
		if (index < 0 || index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SxtLinkedList list = new SxtLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add(1,"ddd");
		list.set(1,"BBB");
//		list.remove(2);
		System.out.println(list.size);
		System.out.println(list.get(3));
	}



	
}
