package testthread.status;

public class YieldTest01 implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		
		YieldTest01 test = new YieldTest01();
		Thread t = new Thread(test);//����
		t.start();//����
		//cpu��������
		
		for(int i=0; i<100; i++){
			
			if(i%20==0){
				Thread.yield();//��ͣ���߳�main ��̬���� д���ĸ��߳��������ͣ�ĸ�
			}
			System.out.println("main..."+i);
		}
	}
	
	public void run(){
		
		for(int i=0; i<100; i++){
			System.out.println("yield..."+i);
		}
	}
}
