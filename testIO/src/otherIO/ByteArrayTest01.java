package otherIO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组 节点流
 * 数组长度有限，数据量不会很大
 * 
 * 文件内容不大
 * 1、文件内容-->文件输入流+字节数组输出流-->字节数组
 * 2、字节数组-->字节数组输入流+文件输出流-->文件
 * 
 * 
 * @author yinyiliang
 *
 */
public class ByteArrayTest01 {

	
	public static void main(String[] args) throws IOException {
		read(write());
	}
	
	/**
	 * 输入流 操作与文件输入流操作一致	
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException{
		
//		//数据源
//		String msg = "lalalala";
//		byte[] src = msg.getBytes();
		
		//选择流
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src) //和外界没有联系不用加异常
				);
		
		//操作
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){//这里抛出异常，因为有可能读取失败
			System.out.println(new String(flush,0,len));
		}
		
		//释放资源
		is.close();
	}
	
	/**
	 * 输出流
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException{
		
		byte[] dest;
		
		//和选择流不同点
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//操作 写出
		String msg = "哈哈哈哈哈";
		byte[] info = msg.getBytes();
		bos.write(info,0,info.length);
	
		//获取数据
		//和选择流不同点
		dest = bos.toByteArray();
		
		//释放资源
		bos.close();
		
		return dest;
	}
}
