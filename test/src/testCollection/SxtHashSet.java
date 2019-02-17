package testCollection;

import java.util.HashMap;

public class SxtHashSet {
	
	HashMap map;//用来存放对象元素信息的
	//所有元素都当作map里的key来存放，key不可重复，value可重复
	private static final Object PRESENT = new Object();//value是一个常量
	
	public SxtHashSet(){
		map = new HashMap();
	}
	
	public int size(){
		return map.size();//直接利用map里的size即可不用自己定义
	}
	
	public void add(Object o){
		map.put(o, PRESENT);//set的不可重复就是利用了map里面键对象的不可重复
	}
	
	public static void main(String[] args) {
		SxtHashSet s = new SxtHashSet();
		s.add("aaa");
		s.add(new String("aaa"));
		System.out.println(s.size());
	}
}
