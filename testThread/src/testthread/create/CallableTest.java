package testthread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 使用Callable接口创建线程 可以声明异常 有返回值
 * 
 * @author yinyiliang
 *
 */
public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//创建线程
		ExecutorService ser = Executors.newFixedThreadPool(2);//目前有两个线程
		Race tortoise = new Race("乌龟",1000);
		Race rabbit = new Race("兔子",500);
		
		//获取值
		Future<Integer> result1 = ser.submit(/*实现类对象*/tortoise);
		Future<Integer> result2 = ser.submit(/*实现类对象*/rabbit);
		
		Thread.sleep(2000);//2秒停
		tortoise.setFlag(false);//停止线程体循环
		rabbit.setFlag(false);
		
		int num1 = result1.get();
		int num2 = result2.get();
		
		System.out.println(tortoise.getName()+"跑了"+num1+"步");
		System.out.println(rabbit.getName()+"跑了"+num2+"步");
		
		//停止线程服务
		ser.shutdownNow();
	}
}

class Race implements Callable<Integer>{

	private String name;//名称
	private long time;//延时的时间
	private boolean flag = true;
	private int step = 0;//步
	
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
			Thread.sleep(time);//延时 走的多慢
			step++;
		}
		return step;
	}
	
}