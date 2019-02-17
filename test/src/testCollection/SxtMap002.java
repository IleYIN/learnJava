package testCollection;

import java.util.LinkedList;

/**
 * 自定义Map的升级版
 * 提高查询效率避免循环遍历
 * 
 * @author yinyiliang
 *
 */
public class SxtMap002 {

	LinkedList[] arr = new LinkedList[999];
	//SxtLinkedList[]是数组，SxtLinkedList是之前建好的链表类，容器里面套容器，此处是数组里面套链表
	//Map的底层结构就是数组+链表
	int size;
	
	public void put(Object key, Object value){
		SxtEntry e = new SxtEntry(key,value);
		
		//有的时候hashCode返回的是负值，负值取余后可能还是负数会有问题要改进
		int hash = key.hashCode();
		hash = hash<0 ? -hash : hash;
		
		int a = hash%arr.length;
		//hashCode是根据地址生成的hash码
		//1000-->1  10000-->10  弊端是余数有可能重复，所以将相同余数的放一个链表里
		if (arr[a]==null){
			LinkedList list = new LinkedList();
			arr[a] = list;
			//SxtLinkedList()是链表对象
			list.add(e);
		} else {
			
			//判断是不是有重复的key来进行覆盖
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				SxtEntry e2 = (SxtEntry) list.get(i);
				if (e2.key.equals(key)){
					e2.value = value; //键重复直接覆盖
					return;
				}
			}
			//若没有重复就直接放进去
			arr[a].add(e);
		}
	}
	
	public Object get(Object key){
//		return arr[key.hashCode()%999];
		int a = key.hashCode()%arr.length;
		if (arr[a]!=null){
			LinkedList list = arr[a];
			//SxtLinkedList()是链表对象, 下面遍历列表
			for (int i = 0; i < list.size(); i++) {
				SxtEntry e = (SxtEntry) list.get(i);
				if (e.key.equals(key)){
					return e.value;
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		SxtMap002 m = new SxtMap002();
		m.put("张三", new Wife("张三的妻子"));
		m.put("李四", new Wife("李四的妻子"));
		m.put("李四", new Wife("李四的二任妻子"));
		Wife w = (Wife)m.get("李四");
		System.out.println(w.name);
	}
	
	
}
