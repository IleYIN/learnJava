package testthread.syn;


/**
 * synchronized �� �̰߳�ȫ
 * synchronized(��������|this|��.class)
 * 
 * https://blog.csdn.net/xiao__gui/article/details/8188833
 * https://www.jianshu.com/p/7ef502580df3
 * 
 * 
 * 
 * @author yinyiliang
 *
 */
public class SynTest01 {


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

class Web12306 implements Runnable {

	private int num = 10;

	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag){
			test4();
		}
	}
	
	
	//�̲߳���ȫ ������Դ����ȷ����û������num ���ֻ������
	public void test6(){

		if(num<=0){
			flag = false;
			return;//����ѭ��
		}
		
		//a b c
		synchronized(this){
			
			try {
				Thread.sleep(500);//����ʱ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������Ʊ"+num--);
		}
	}
	
	//�̲߳���ȫ ������Դ����ȷ����û������this(a b c)ͬһ�������ܱ����ȡ����
	public void test5(){
		
		//a b c
		synchronized((Integer)num){
			
			if(num<=0){
				flag = false;
				return;//����ѭ��
			}
			try {
				Thread.sleep(500);//����ʱ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������Ʊ"+num--);
		}
	}
		
	
	//������Χ����ȷ
		public void test4(){
			
			synchronized(this){
				
				if(num<=0){
					flag = false;
					return;//����ѭ��
				}
			}
			try {
				Thread.sleep(500);//����ʱ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������Ʊ"+num--);
		}
	
	
	//�̰߳�ȫ ������ȷ
	public void test3(){
		
		synchronized(this){//�����߳�
			
			if(num<=0){
				flag = false;
				return;//����ѭ��
			}
			try {
				Thread.sleep(500);//����ʱ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������Ʊ"+num--);
		}
	}
		
	
	
	//�̰߳�ȫ ������ȷ
	public synchronized void test2(){
		if(num<=0){
			flag = false;
			return;//����ѭ��
		}
		try {
			Thread.sleep(500);//����ʱ
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"������Ʊ"+num--);
	}
	
	
	//�̲߳���ȫ
	public void test1(){
		if(num<=0){
			flag = false;
			return;//����ѭ��
		}
		try {
			Thread.sleep(500);//ע�����ʱ�����ݱ�ò�׼ȷ ����0,-1 �������� abc�������浼��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"������Ʊ"+num--);
	}
}