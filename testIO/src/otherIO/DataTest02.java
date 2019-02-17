package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * 数据类型（基本+String）处理流
 * 
 * 数据+类型输出到字节数组中
 * 
 * java.io.EOFException异常： 表示已达到末尾 没有读取到相关的内容
 * 顺序不一致也会出问题
 * 
 * @author yinyiliang
 *
 */
public class DataTest02 {

	public static void main(String[] args) {
		
		try {
//			write("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
//			read("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
//			read("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
			
			byte[] data = write();
			System.out.println(data.length);
			read(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从字节数组读取数据+类型
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException{
		
		//选择流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				); 
		
		//操作读取的顺序与写出的一致 必须存在才能读取
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		
		dis.close();
		
		System.out.println(num1+"	"+num2+"	"+str);
	}
	
	
	
	/**
	 * 数据+类型输出到字节数组中(输出的东西是机器能懂的人不能懂的)
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException{
		
		//目标数组
		byte[] dest = null;
		
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		
		//选择流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						bos
						)
				);
 	
		//操作 写出的顺序 为读取做准备 必须一致
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		
		dest = bos.toByteArray();
		
		//释放
		dos.close();
		
		bos.close();//可加可不加
		
		return dest;
	}
}
