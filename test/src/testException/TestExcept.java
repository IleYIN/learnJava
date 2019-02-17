package testException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestExcept {
	public static void main(String[] args) {
//		int i = 1/0;
//		Computer c = null;
//		if (c!=null){
//			c.start(); //对象是null,调用了对象方法或属性！栈里指针是空的
//		}
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();
//		System.out.println(a);//若输入的不是数字就会有InputMismatchException
		
//		String str = "1234abc";
//		Integer i = new Integer(str);//NumberFormatException
		
//		try {
//			Thread.sleep(3000);//checked Exception
//		} catch (InterruptedException e) {//checked Exception
//			e.printStackTrace();
//		}finally{
//			System.out.println("aaa");
//		}
		
		//下面是手动抛出异常
		
		File f = new File("pw2.txt"); //File代表一个文件或目录
		if (!f.exists()){ //如果不存在
			try {
				throw new FileNotFoundException("File can't be found!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Computer{
	void start(){
		System.out.println("计算机启动");
	}
}