package testthread.status;

/**
 * join�ϲ��߳�
 * 
 * @author yinyiliang
 *
 */
public class JoinTest01 implements Runnable{//����extends Thread

	public static void main(String[] args) throws InterruptedException {
		
		JoinTest01 test = new JoinTest01();
		Thread t = new Thread(test);//����
		t.start();//����
		//cpu��������
		
		for(int i=0; i<100; i++){
			
			if(50==i){
				t.join();//�ȴ�t�߳̽�����main�̱߳�����
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

