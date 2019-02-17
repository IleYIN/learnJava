package testmyCollection;


/**
 * ģ��ʵ��JDK���ṩ��ArrayList�ࣨ�����ĵײ�ʵ�֣�
 * 
 * @author yinyiliang
 *
 */

public class MyArrayList {
	private Object[] value;
	private int size;
	
	public MyArrayList(){
	//	value = new Object[16];
		this(10);
	}
	
	public MyArrayList(int size){
		if(size<0){
			try {
				throw new Exception(); //�����쳣ֹͣ���� 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		value = new Object[size];
	}
	
	//�жϴ�С
	public int size(){
		return size;
	}
	
	//�ж��ǲ��ǿ�
	public boolean isEmpty(){
		return size==0;  
	}
	
	//���������������
	public int indexOf(Object obj){
		if(obj==null){
			return -1;
		}else{
			for(int i=0; i<value.length; i++){
				if (obj==value[i]){
					return i;
				}
			}
			return -1;
		}
	}
	
	//���������������
	public int lastIndexOf(Object obj){
		if(obj==null){
			return -1;
		}else{
			for(int i=value.length-1; i>=0 ; i--){
				if (obj==value[i]){
					return i;
				}
			}
			return -1;
		}
	}
	
	
	//�ж�index����Ƿ񳬳���Χ
	public void rangeCheck(int index){
		if(index<0||index>size-1){
			try {
				throw new Exception(); //�����쳣ֹͣ���� 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	//set ��ֵ
	public Object set(int index, Object object){
		
		
//		if(index<0||index>size-1){
//			try {
//				throw new Exception(); //�����쳣ֹͣ���� 
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		rangeCheck(index);
		
		Object old = value[index];
		value[index] = object;
		return old;
	}
	
	
	
	
	//����
	public void add(Object obj){
		value[size] = obj;
		size++;
		if(size >= value.length){
			//װ��������Ҫ����
			int newCapacity = value.length*2;
			Object[] newList = new Object[newCapacity];
//			System.arraycopy(src, srcPos, dest, destPos, length); ��������Լ�д
			for (int i=0; i<value.length ; i++){ //����дi<size��һ���ģ���Ϊ��ʱsize=value.length
				newList[i] = value[i];
			}
			value = newList;
			//�Զ�����
		}
	}
	
	
	//ȡ��
	public Object get(int index){
		rangeCheck(index);
		return value[index];
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("aaa");
		list.add(new Human("����"));
		list.add("bbbb");
		list.add("bbbb");
		list.add("bbbb");
		list.add("bbbb");
		
//		System.out.println(list.get(1));//�������object��tostring
		
		Human h = (Human)list.get(1);
		System.out.println(h.getName());
		
		System.out.println(list.get(2));
//		System.out.println(list.get(-1));
//		System.out.println(list.get(3));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.indexOf("bbbb"));
		System.out.println(list.lastIndexOf("bbbb"));
		System.out.println(list.set(3, "fgh"));//��ӡ��ԭ����value[3]
		System.out.println(list.get(3));//��ӡ���µ�value[3]
	}
}
