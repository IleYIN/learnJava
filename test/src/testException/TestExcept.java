package testException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestExcept {
	public static void main(String[] args) {
//		int i = 1/0;
//		Computer c = null;
//		if (c!=null){
//			c.start(); //������null,�����˶��󷽷������ԣ�ջ��ָ���ǿյ�
//		}
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();
//		System.out.println(a);//������Ĳ������־ͻ���InputMismatchException
		
//		String str = "1234abc";
//		Integer i = new Integer(str);//NumberFormatException
		
//		try {
//			Thread.sleep(3000);//checked Exception
//		} catch (InterruptedException e) {//checked Exception
//			e.printStackTrace();
//		}finally{
//			System.out.println("aaa");
//		}
		
		//�������ֶ��׳��쳣
		
		File f = new File("pw2.txt"); //File����һ���ļ���Ŀ¼
		if (!f.exists()){ //���������
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
		System.out.println("���������");
	}
}