package testCollections.QueueEnumeration;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用队列实现自定义堆栈 LIFO
 * 弹
 * 压
 * 获取头
 * 
 * 
 * Java中Queue的一些常用方法
 * 
 * add         增加一个元索                      如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
 * offer       添加一个元素并返回true        如果队列已满，则返回false
 * poll         移除并返问队列头部的元素     如果队列为空，则返回null
 * peek       返回队列头部的元素              如果队列为空，则返回null
 * put         添加一个元素                       如果队列满，则阻塞
 * take        移除并返回队列头部的元素    
 * 
 * 
 * 
 * 
 * 
 * Deque接口双端队列，可以当做栈和队列来使用。 用他的实现类linkedlist 。
 * 添加元素、删除元素：当做栈使用：push添加 pop删除
 * 				当做队列使用：offer添加 poll删除
 * 
 * @author yinyiliang
 *
 */

public class MyStack<E> {

	//容器
	private Deque<E> container = new ArrayDeque<E>();
	//容量
	private int cap;
	public MyStack(int cap){
		super();
		this.cap = cap;
	}
	
	//压栈
	public boolean push(E e){//进
		if (container.size()+1 > cap){
			return false;
		}
		return container.offerLast(e);//在末尾添加e成功返回true
	}
	//弹栈
	public E pop(){//出
		return container.pollLast();//返回末尾的e并移除e
	}
	//获取
	public E peek(){//偷看
		return container.peekLast();//获取末尾的 为空返回null
	}
	
	public int size(){
		return container.size();
		
	}
}
