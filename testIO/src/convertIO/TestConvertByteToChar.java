package convertIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 转换流：字节转为字符
 * 输出流OutputStreamWriter编码
 * 输入流InputStreamWriter解码
 * @author yinyiliang
 *
 */
public class TestConvertByteToChar {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("D:/informatique/MyEclipse workspace/testIO/parent/TestConvertCharSet.java")),
						//由于读取源文件时不能指定字符集（而我们的文件用的是UTF-8字符集） 所以为保持文档不会有乱码只能底层使用字节流
						"UTF-8"
						//所以读取时需要转换流InputStreamReader把字节转成字符,此时就可以添加字符集了
						)
				);  
		//写出文件
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:/informatique/MyEclipse workspace/testIO/parent/Copy.java")
				);
		String info = null;
		while(null != (info=br.readLine())){
			bw.write(info+"\r\n");
			bw.flush();
			System.out.println(info);
		}
		bw.close();
		br.close();
	}
}
