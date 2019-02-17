package testthread.status;

public class YieldTest01 implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		
		YieldTest01 test = new YieldTest01();
		Thread t = new Thread(test);//新生
		t.start();//就绪
		//cpu调度运行
		
		for(int i=0; i<100; i++){
			
			if(i%20==0){
				Thread.yield();//暂停本线程main 静态方法 写在哪个线程体里就暂停哪个
			}
			System.out.println("main..."+i);
		}
	}
	
	public void run(){
		
		for(int i=0; i<100; i++){
			System.out.println("yield..."+i);
		}
	}
}
