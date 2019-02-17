package testthread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * �������
 * 
 * Timer()
 * timer.schedule(task, time);
 * timer.schedule(task, firstTime, period);
 * 
 * ��ѧQuartz Scheduler jar��
 * 
 * @author yinyiliang
 *
 */
public class TimerTest01 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("TimerTask��дrun����");
			}
			
		}, new Date(System.currentTimeMillis()+1000),500);
		//��ǰʱ���1������У�ÿ��500msһ��
	}
}
