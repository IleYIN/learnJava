package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * 文件内容不大
 * 1、文件内容-->文件输入流+字节数组输出流-->字节数组
 * 2、字节数组-->字节数组输入流+文件输出流-->文件
 * 
 * 注意 字节数组输出流有新增方法不能多态 和其他的不一样
 * 
 * @author yinyiliang
 *
 */
public class ByteArrayTest02 {

	
	public static void main(String[] args) throws IOException {
		
		byte[] data = getBytesFromFile("D:/informatique/MyEclipse workspace/testIO/src/earth.png");
//		System.out.println(new String(data));
		toFileFromByteArray(data, "D:/informatique/MyEclipse workspace/testIO/parent/earth.png");
	}
	
	
	/**
	 * 1、文件内容-->文件输入流+字节数组输出流-->字节数组
	 * @throws FileNotFoundException 
	 */
	public static byte[] getBytesFromFile(String srcPath) throws FileNotFoundException, IOException {
		
		//创建文件源
		File src = new File(srcPath);
		
		//创建字节数组目的地
		byte[] dest = null;
		
		//选择流
		//文件输入流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		
		//字节数组输出流不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//操作 不断读取文件 写出到字节数组流中
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))){
	
			//写出到字节数组流中
			bos.write(flush,0,len);
		}
		bos.flush();
		
		//获取数据
		dest = bos.toByteArray();
		//关闭
		bos.close();
		is.close();
		
		return dest;
	}

	
	/**
	 * 2、字节数组-->字节数组输入流+文件输出流-->文件
	 */
	public static void toFileFromByteArray(byte[] src, String destPath)throws IOException{
		
		//创建源
		//目的地
		File dest = new File(destPath);
		
		//选择流
		//字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		
		//文件输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		
		//操作 不断读取字节数组 输出到文件
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){
			os.write(flush,0,len);
		}
		os.flush();
		
		//释放资源
		os.close();
		is.close();
	}
}
