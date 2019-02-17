package bufferdIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符缓冲流+新增方法
 * 
 * @author yinyiliang
 *
 */
public class BufferedCharTest {

	public static void main(String[] args) {
		
		File src = new File("D:/informatique/MyEclipse workspace/testIO/src/charIO/test.txt");
		File dest = new File("D:/informatique/MyEclipse workspace/testIO/src/charIO/char.txt");
		
//		Reader reader = null;
//		Writer wr = null;
		//使用新增方法不能发生多态
		BufferedReader reader = null;
		BufferedWriter wr = null;

		try {
			reader = new BufferedReader(new FileReader(src));
			wr = new BufferedWriter(new FileWriter(dest,true));//加上true表示追加 保留原来的东西

			//读取操作
			/*
			char[] flush = new char[1024];
			int len = 0;
			while(-1 != (len=reader.read(flush))){
				wr.write(flush,0,len);
			}
			wr.flush();//强制刷出
			*/
			//按行读取
			String line = null;
			while(null != (line=reader.readLine())){
				wr.write(line);
//				wr.append("\r\n");
				wr.newLine();//换行符号
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		} finally{//后打开的先关闭
			try {
				if (null != wr) {
					wr.close();
				} 
			} catch (Exception e2) {
				System.out.println("所写文件关闭失败");
			}
			try {
				if (null != reader) {
					reader.close();//选中if的几行然后alt+shift+Z
				} 
			} catch (Exception e2) {
				System.out.println("所读文件关闭失败");
			}
		}
	}
}
