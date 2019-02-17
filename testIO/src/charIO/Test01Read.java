package charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 纯文本读取
 * 
 * @author yinyiliang
 *
 */
public class Test01Read {

	public static void main(String[] args) {
		
		File src = new File("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
		
		Reader reader = null;
		
		try {
			reader = new FileReader(src);
			
			//读取操作
			char[] flush = new char[1024];
			int len = 0;
			while(-1 != (len=reader.read(flush))){
				//字符数组转成字符串
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		} finally{
			try {
				if (null != reader) {
					reader.close();//选中if的几行然后alt+shift+Z
				} 
			} catch (Exception e2) {
				System.out.println("无法关闭");
			}
		}
	}
}
