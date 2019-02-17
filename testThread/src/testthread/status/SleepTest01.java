package testthread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 * 1、倒数10个数，一秒打印一个
 * 2、倒计时
 * 
 * @author yinyiliang
 *
 */
public class SleepTest01 {

	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);//当前时间后的第10秒
		long end = endTime.getTime();
		while(true){
			
			System.out.println(new SimpleDateFormat("hh:mm:ss").format(endTime));
			
			Thread.sleep(1000);//一秒后再执行之后的操作
			
			//构建下一秒的时间
			endTime = new Date(endTime.getTime()-1000);//倒计时 每次减一秒
			
			//退出循环的条件
			if(end-10*1000>endTime.getTime()){//endTime.getTime已经减到了曾经的当前时间，也就是说这10秒结束了，则退出
				break;
			}
		}
	}
	
	public static void test1() throws InterruptedException{
		int num = 10;
		while(true){
			System.out.println(num--);
			Thread.sleep(1000);//暂停
			if(num<=0){
				break;
			}
		}
	}
}
