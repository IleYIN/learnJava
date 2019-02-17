package testthread.status;

/**
 * join合并线程
 * 
 * @author yinyiliang
 *
 */
public class JoinTest01 implements Runnable{//或者extends Thread

	public static void main(String[] args) throws InterruptedException {
		
		JoinTest01 test = new JoinTest01();
		Thread t = new Thread(test);//新生
		t.start();//就绪
		//cpu调度运行
		
		for(int i=0; i<100; i++){
			
			if(50==i){
				t.join();//等待t线程结束，main线程被阻塞
			}
			System.out.println("main..."+i);
		}
	}
	
	public void run(){
		
		for(int i=0; i<100; i++){
			System.out.println("join..."+i);
		}
	}
}

