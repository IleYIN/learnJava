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
			last = n;//��Ϊ��ֻ����ôһ���ڵ� ����firstҲ��last
		} else {
			//first���ǿ�˵���нڵ���ڣ�ֱ�������һ���ڵ�ĩβlast�����
			n.setPrevious(last);//�ýڵ��previous��֮ǰ�����һ���ڵ�
			n.setObj(obj);
			n.setNext(null);
			
			last.setNext(n);//֮ǰ�����һ���ڵ��next������null���������ĸýڵ�n
			
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
			//�������� 0 1 2 3 4 ֱ��index
		
			//����index��size/2��size>>1��Ϊ,���Ƚ϶����Ǳ�����Ч�ʻ����
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
		//indexԽ����δ���
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
		//�����½ڵ�
		Node newNode = new Node();
		//��λ��
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
		//��λ��
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
