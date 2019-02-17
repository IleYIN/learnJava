package testthread.create;
/**
 * 模拟龟兔赛跑
 * 创建多线程 继承Thread + 重写run（线程体）
 * 
 * 使用线程：创建子类对象  + 调用对象.start方法 -->线程启动
 * 
 * @author yinyiliang
 *
 */
public class Rabbit extends Thread {
	//alt+shift+s-->override 或者alt+/ 找到run方法
	@Override
	public void run() {
		for(int i=0; i<100; i++){
			System.out.println("兔子跑了"+i+"步");
		}
	}
}


class Tortoise extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<100; i++){
			System.out.println("乌龟跑了"+i+"步");
		}
	}
}