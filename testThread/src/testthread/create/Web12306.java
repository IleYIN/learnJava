package testthread.create;

/**
 * ���㹲����Դ
 * 
 * @author yinyiliang
 *
 */
public class Web12306 implements Runnable {

	private int num = 50;
	
	@Override
	public void run() {
		while(true){
			if(num<=0){
				break;//����ѭ��
			}
			System.out.println(Thread.currentThread().getName()+"������Ʊ"+num--);
		}
	}
	
	public static void main(String[] args) {
		
		//��ʵ��ɫ
		Web12306 web = new Web12306();
		
		//����
		Thread t1 = new Thread(web,"����Ʊ��1");
		Thread t2 = new Thread(web,"����Ʊ��2");
		Thread t3 = new Thread(web,"����Ʊ��3");
		
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
		
	}
}
