package testthread.info;

/**
 * ���ȼ�������ǳ��ֵĸ��� ����˳�� ���Ǿ��Ե����ȼ�
 * 
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5 ��Ĭ��Ϊ5��
 * MIN_PRIORITY 1
 * 
 * @author yinyiliang
 *
 */
public class InfoTest02 {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread t1 = new MyThread();//�����߳� 
		Thread p1 = new Thread(t1,"t1");
		
		MyThread t2 = new MyThread();//�����߳� 
		Thread p2 = new Thread(t2,"t2");
		
		p1.setPriority(Thread.MIN_PRIORITY);//�������ȼ�
		p2.setPriority(Thread.MAX_PRIORITY);//�������ȼ�
		
		p1.start();
		p2.start();
		
		Thread.sleep(100);
		t1.stop();
		t2.stop();
	}
}
