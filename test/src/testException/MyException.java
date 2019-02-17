package testException;

public class MyException extends Exception { //Exception属于lang包不用导入
	public MyException(){
		
	}
	
	public MyException(String message){
		super(message);
	}

	public static void main(String[] args) {
		try{
			new TestMyException().test();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}

class TestMyException{
	void test() throws MyException{
		
	}
}