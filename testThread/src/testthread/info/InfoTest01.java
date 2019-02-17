package testthread.info;
/**
 * Thread.currentThread --> ��̬���� д���ĸ��߳������ĸ��̵߳�
 * setName()
 * getName()
 * isAlive()�ж�״̬
 * 
 * 
 * @author yinyiliang
 *
 */
public class InfoTest01 {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread t1 = new MyThread();//�����߳� 
		Thread proxy = new Thread(t1,"t1");//Thread��ʵ��Runnable�ӿ� ������������
//		proxy.setName("test");//Ҳ����������������
		
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());//��ǰ�߳�Ҳ����main�߳�
		
		proxy.start();
		System.out.println("�������״̬:"+proxy.isAlive());
		Thread.sleep(200);
		t1.stop();
		Thread.sleep(100);
		System.out.println("ֹͣ���״̬:"+proxy.isAlive());
		
	}
}
