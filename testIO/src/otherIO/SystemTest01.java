package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ��������
 * System.in ��������
 * System.out ����̨���
 * System.err
 * 
 * 
 * ==>�ض���
 * setIn()
 * setOut()
 * setErr()
 * 
 * ����̨
 * FileDescripter.out
 * FileDescripter.in
 * FileDescripter.err
 * 
 * @author yinyiliang
 *
 */
public class SystemTest01 {

	public static void main(String[] args) throws FileNotFoundException {
//		test1();
//		test2();
	
		//�ض���Ѵ�ӡ�ķŵ��ļ���
		System.setOut(new PrintStream(
				new BufferedOutputStream(new FileOutputStream("D:/informatique/MyEclipse workspace/testIO/parent/print.txt"))
				,true)//true��ʾautoFlush
				);
		System.out.println("print");//����̨-->�ļ�
		System.out.println("�ض���");
		
		//�ؿ���̨
		System.setOut(new PrintStream(
				new BufferedOutputStream(new FileOutputStream(FileDescriptor.out))
				,true)
				);
		System.out.println("back");
	}
	
	public static void test1(){
		System.out.println("test");
		System.err.println("err");
	}
	
	public static void test2() throws FileNotFoundException{
		
		InputStream is = System.in;//��ʾ��������
		
		//���ļ�������
		is = new BufferedInputStream(new FileInputStream("D:/informatique/MyEclipse workspace/testIO/parent/1.txt"));
		
		Scanner sc = new Scanner(is);
//		System.out.println("������");
		System.out.println(sc.nextLine());
	}
}
