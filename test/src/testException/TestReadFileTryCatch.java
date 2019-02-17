package testException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFileTryCatch {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("pw.txt");//和外部文件有关所以要加try catch来避免出错
			char c = (char)reader.read();//抛出IOException
			char c2 = (char)reader.read();//抛出IOException
			System.out.println(c+c2);//这里的加号被当成字符相加了
			System.out.println(""+c+c2);//字符相连
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {//FileNotFoundException是IOException的子类，子类放前面，父类放后面，不然子类无法被处理
			e.printStackTrace();
		}finally{  //注意不要在finally里加return，它会覆盖之前try或catch里的return语句
			try {
				if (reader != null) //避免reader是空
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//抛出异常
		}
		
	}
}
