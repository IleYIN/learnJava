package testthread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度
 * 
 * Timer()
 * timer.schedule(task, time);
 * timer.schedule(task, firstTime, period);
 * 
 * 自学Quartz Scheduler jar包
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
				System.out.println("TimerTask重写run方法");
			}
			
		}, new Date(System.currentTimeMillis()+1000),500);
		//当前时间的1秒后运行，每隔500ms一次
	}
}
