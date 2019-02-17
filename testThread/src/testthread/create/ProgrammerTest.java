package testthread.create;

public class ProgrammerTest {

	public static void main(String[] args) {
		
		// 创建真实角色
		Programmer pro = new Programmer();
		//创建代理角色+真实角色引用  
		Thread proxy = new Thread(pro);
		//调用.start()启动线程
		proxy.start();
		
		for(int i=0; i<1000; i++){
			System.out.println("聊qq");
		}
		
	}
}
