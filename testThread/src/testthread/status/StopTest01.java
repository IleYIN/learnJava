package testthread.status;

public class StopTest01 {

	public static void main(String[] args) {
		Study s = new Study();
		new Thread(s).start();
		
		//外部干涉
		for(int i=0; i<100; i++){
			if(50==i){//外部干涉
				s.stop();
			}
			System.out.println("main..."+i);
		}
	
	}
}

class Study implements Runnable{
	
	private boolean flag = true;

	@Override
	public void run() {

		while(flag){
			System.out.println("study thread...");
		}
	}
	
	public void stop(){
		this.flag = false;
	}
}