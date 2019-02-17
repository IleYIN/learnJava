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
 * 三个常量
 * System.in 键盘输入
 * System.out 控制台输出
 * System.err
 * 
 * 
 * ==>重定向
 * setIn()
 * setOut()
 * setErr()
 * 
 * 控制台
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
	
		//重定向把打印的放到文件里
		System.setOut(new PrintStream(
				new BufferedOutputStream(new FileOutputStream("D:/informatique/MyEclipse workspace/testIO/parent/print.txt"))
				,true)//true表示autoFlush
				);
		System.out.println("print");//控制台-->文件
		System.out.println("重定向");
		
		//回控制台
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
		
		InputStream is = System.in;//表示键盘输入
		
		//从文件中输入
		is = new BufferedInputStream(new FileInputStream("D:/informatique/MyEclipse workspace/testIO/parent/1.txt"));
		
		Scanner sc = new Scanner(is);
//		System.out.println("请输入");
		System.out.println(sc.nextLine());
	}
}
