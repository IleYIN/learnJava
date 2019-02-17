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
public class RabbitTest {

	public static void main(String[] args) {
		//创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();

		//调用start方法-->线程启动
		rab.start();//注意不要调用run方法 程序内部会自己调用普通方法
		tor.start();
		
		for(int i=0; i<200; i++){
			System.out.println("main-->"+i);
		}
	}
}
