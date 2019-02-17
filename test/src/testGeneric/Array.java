package testGeneric;

/**
 * 没有泛型数组，不能创建泛型数组也就是不能开辟空间
 * 内部是Object强转成E
 * 可以声明  可以用?
 * @author yinyiliang
 *
 */
public class Array {
	public static void main(String[] args) {
		Integer[] arr = new Integer[4];
//		StudentWenhao<String>[] arr2 = new StudentWenhao<String>[10];
//		不能创建泛型数组,可以下面那样写但是没有意义
		StudentWenhao<String>[] arr2 = new StudentWenhao[10];
		StudentWenhao<?>[] arr3 = new StudentWenhao[10];
		
		MyArrayList<String> strList = new MyArrayList<String>();
		strList.add(0, "a");
		System.out.println(strList.getElem(0));
	}
}

class MyArrayList<E>{
	
//	E[] ele = new E[10]; 不行
//	E[] ele2 = new Object[10];不行 没有泛型数组
	
	
	//Object可以接收任意类型
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