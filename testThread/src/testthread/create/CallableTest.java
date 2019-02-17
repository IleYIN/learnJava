package testthread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * ʹ��Callable�ӿڴ����߳� ���������쳣 �з���ֵ
 * 
 * @author yinyiliang
 *
 */
public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//�����߳�
		ExecutorService ser = Executors.newFixedThreadPool(2);//Ŀǰ�������߳�
		Race tortoise = new Race("�ڹ�",1000);
		Race rabbit = new Race("����",500);
		
		//��ȡֵ
		Future<Integer> result1 = ser.submit(/*ʵ�������*/tortoise);
		Future<Integer> result2 = ser.submit(/*ʵ�������*/rabbit);
		
		Thread.sleep(2000);//2��ͣ
		tortoise.setFlag(false);//ֹͣ�߳���ѭ��
		rabbit.setFlag(false);
		
		int num1 = result1.get();
		int num2 = result2.get();
		
		System.out.println(tortoise.getName()+"����"+num1+"��");
		System.out.println(rabbit.getName()+"����"+num2+"��");
		
		//ֹͣ�̷߳���
		ser.shutdownNow();
	}
}

class Race implements Callable<Integer>{

	private String name;//����
	private long time;//��ʱ��ʱ��
	private boolean flag = true;
	private int step = 0;//��
	
	public Race() {

	}
	
	public Race(String name) {
		super();
		this.name = name;
	}
	
	public Race(String name, long time) {
		super();
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public Integer call() throws Exception {
		
		while(flag){
			Thread.sleep(time);//��ʱ �ߵĶ���
			step++;
		}
		return step;
	}
	
}