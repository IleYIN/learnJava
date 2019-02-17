package testthread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ
 * 1������10������һ���ӡһ��
 * 2������ʱ
 * 
 * @author yinyiliang
 *
 */
public class SleepTest01 {

	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);//��ǰʱ���ĵ�10��
		long end = endTime.getTime();
		while(true){
			
			System.out.println(new SimpleDateFormat("hh:mm:ss").format(endTime));
			
			Thread.sleep(1000);//һ�����ִ��֮��Ĳ���
			
			//������һ���ʱ��
			endTime = new Date(endTime.getTime()-1000);//����ʱ ÿ�μ�һ��
			
			//�˳�ѭ��������
			if(end-10*1000>endTime.getTime()){//endTime.getTime�Ѿ������������ĵ�ǰʱ�䣬Ҳ����˵��10������ˣ����˳�
				break;
			}
		}
	}
	
	public static void test1() throws InterruptedException{
		int num = 10;
		while(true){
			System.out.println(num--);
			Thread.sleep(1000);//��ͣ
			if(num<=0){
				break;
			}
		}
	}
}
