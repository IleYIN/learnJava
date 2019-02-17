package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型（基本+String）处理流
 * 
 * java.io.EOFException异常： 表示已达到末尾 没有读取到相关的内容
 * 顺序不一致也会出问题
 * 
 * @author yinyiliang
 *
 */
public class DataTest01 {

	public static void main(String[] args) {
		
		try {
//			write("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
//			read("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
			read("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从文件读取数据+类型
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException{
		
		//创建源
		File src = new File(destPath);
		//选择流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				); 
		
		//操作读取的顺序与写出的一致 必须存在才能读取
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		
		dis.close();//可不加
		System.out.println(num1+"	"+num2+"	"+str);
	}
	
	
	
	/**
	 * 数据+类型输出到文件(输出的东西是机器能懂的人不能懂的)
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException{
		
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		
		//创建源
		File dest = new File(destPath);
		
		//选择流
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
 	
		//操作 写出的顺序 为读取做准备 必须一致
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		
		//释放
		dos.close();
	}
}
