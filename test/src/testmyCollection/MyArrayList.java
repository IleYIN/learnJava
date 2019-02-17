package testmyCollection;


/**
 * 模拟实现JDK中提供的ArrayList类（容器的底层实现）
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
				throw new Exception(); //丢出异常停止运行 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		value = new Object[size];
	}
	
	//判断大小
	public int size(){
		return size;
	}
	
	//判断是不是空
	public boolean isEmpty(){
		return size==0;  
	}
	
	//正序索引给出编号
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
	
	//倒序索引给出编号
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
	
	
	//判断index编号是否超出范围
	public void rangeCheck(int index){
		if(index<0||index>size-1){
			try {
				throw new Exception(); //丢出异常停止运行 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	//set 改值
	public Object set(int index, Object object){
		
		
//		if(index<0||index>size-1){
//			try {
//				throw new Exception(); //丢出异常停止运行 
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		rangeCheck(index);
		
		Object old = value[index];
		value[index] = object;
		return old;
	}
	
	
	
	
	//增加
	public void add(Object obj){
		value[size] = obj;
		size++;
		if(size >= value.length){
			//装不下了需要扩容
			int newCapacity = value.length*2;
			Object[] newList = new Object[newCapacity];
//			System.arraycopy(src, srcPos, dest, destPos, length); 或下面的自己写
			for (int i=0; i<value.length ; i++){ //或者写i<size是一样的，因为此时size=value.length
				newList[i] = value[i];
			}
			value = newList;
			//自动扩容
		}
	}
	
	
	//取用
	public Object get(int index){
		rangeCheck(index);
		return value[index];
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("aaa");
		list.add(new Human("人名"));
		list.add("bbbb");
		list.add("bbbb");
		list.add("bbbb");
		list.add("bbbb");
		
//		System.out.println(list.get(1));//输出的是object的tostring
		
		Human h = (Human)list.get(1);
		System.out.println(h.getName());
		
		System.out.println(list.get(2));
//		System.out.println(list.get(-1));
//		System.out.println(list.get(3));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.indexOf("bbbb"));
		System.out.println(list.lastIndexOf("bbbb"));
		System.out.println(list.set(3, "fgh"));//打印出原来的value[3]
		System.out.println(list.get(3));//打印出新的value[3]
	}
}
