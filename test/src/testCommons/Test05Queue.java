package testCommons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * 
 * Queue队列
 * 
 * 1、循环队列-FIFO   CircularFifoQueue
 * 2、只读队列                      UnmodifiableQueue.unmodifiableQueue(queue)
 * 3、断言队列		   PredicatedQueue.predicatedQueue(queue, predicate)
 * 	
 * @author yinyiliang
 *
 */
public class Test05Queue {

	public static void main(String[] args) {
//		circular();
//		readOnly();
		predicate();
	}
	
	
	/**
	 * 循环队列
	 */
	public static void circular() {
		
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		
		//队列有下标
		for(int i=0; i<que.size(); i++){
			System.out.println(que.get(i));
		}
		
	}
	
	/**
	 * 只读队列
	 */
	public static void readOnly(){

		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		
		//包装为只读
		Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
		readOnlyQue.add("d");//java.lang.UnsupportedOperationException
	}
	
	/**
	 * 断言队列
	 */
	public static void predicate(){
		
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		
		Predicate notNull = NotNullPredicate.INSTANCE;
//		Predicate notNull = NotNullPredicate.notNullPredicate();
		
		Queue<String> queNotNull = PredicatedQueue.predicatedQueue(que, notNull);
		queNotNull.add(null);//java.lang.IllegalArgumentException
		
		//队列有下标
		for(int i=0; i<que.size(); i++){
			System.out.println(que.get(i));
		}
	}
}
