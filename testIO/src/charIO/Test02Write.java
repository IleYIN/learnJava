package charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 写出文件
 * write(String,0,length)+flush
 * write(String)
 * append(char|String) 
 * @author yinyiliang
 *
 */
public class Test02Write {

	public static void main(String[] args) {

		File dest = new File("D:/informatique/MyEclipse workspace/testIO/src/charIO/char.txt");

		Writer wr = null;
		try {
			wr = new FileWriter(dest,true);//加上true表示追加 保留原来的东西
			String msg = "锄禾日当午\r\n码农真辛苦\r\n";
			wr.write(msg);
			wr.append("哈哈哈哈\r\n");
			
			wr.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if (null != wr) {
					wr.close();
				} 
			} catch (Exception e2) {
				System.out.println("文件关闭失败");
			}
		}
	}
}
