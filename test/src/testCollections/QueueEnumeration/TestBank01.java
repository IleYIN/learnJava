package testCollections.QueueEnumeration;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟银行存款业务
 * 先进先出
 * 
 * @author yinyiliang
 *
 */
public class TestBank01 {

	public static void main(String[] args) {
		Queue<Request> que = new ArrayDeque<Request>();
		//ArrayDeque是Queue的一个实现类
		//模拟排队情况
		for(int i=0; i<10; i++){
			final int num = i;
			que.offer(
					new Request(){
						//匿名内部类对象只能访问final修饰的
						
						@Override
						public void deposit() {
							System.out.println("第"+num+"个人，办理存款业务，存款额度为："+Math.random()*10000);
						}
						
					}
			);
		}
		dealWith(que);
	}
	
	//处理业务
	public static void dealWith(Queue<Request> que){
		Request req = null;
		while(null!=(req=que.poll())){//poll:移除并返问队列头部的元素   
			req.deposit();//头一个人不是空，则移除这个人并且办存钱业务
		}
	}
}

interface Request{
	//存款业务
	void deposit();
}