package testthread.producer;
/**
 * һ����������ͬ����Դ
 * ������������ģʽ �źŵƷ�
 * 
 * wait��notify�Ǻ�synchronizedһ��ʹ��
 * notify():����   notifyAll()
 * wait():�ȴ����ͷ��������޷�������һ������  
 * sleep���ͷ���
 * 
 * @author yinyiliang
 *
 */
public class Movie {

	private String pic;
	
	//�źŵ�
	//flag-->True  �����������������ߵȴ���������ɺ�֪ͨ����
	//flag-->False ���������ѣ������ߵȴ����������֪ͨ����
	private boolean flag = true;
	
	
	/**
	 * ����
	 */
	public synchronized void play(String pic){
		
		if(!flag){//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		this.pic = pic;
		System.out.println("�����ˣ�"+pic);
		
		//֪ͨ����
		this.notify();
		
		//������ͣ��
		this.flag = false;
	}
	
	/**
	 * �鿴
	 */
	public synchronized void watch(){
		
		if(flag){//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//��ʼ����
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		System.out.println("�����ˣ�"+pic);
		
		//֪ͨ����
		this.notifyAll();
		
		//ֹͣ����
		this.flag = true;
	}
}
