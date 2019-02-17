package byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出文件
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test02Write {

	public static void main(String[] args) {
		
		//建立联系
		File dest = new File("D:/informatique/MyEclipse workspace/testIO/src/byteIO/testwrite.txt");
		
		//选择流 文件输出流 OutputStream FileOutputStream
		OutputStream os = null;
		
		try {
			//以追加的形式写出 加上true 不加则是覆盖
			os = new FileOutputStream(dest,true);
			
			//操作
			String str = "He's very good \r\n";
			//字符串转字节数组
			byte[] data = str.getBytes();
			os.write(data,0,data.length);
			//强制刷新出去 防止看不到
			os.flush();
			
//		} catch (FileNotFoundException e) {
//			System.out.println("文件未找到");
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件写出失败");
			e.printStackTrace();
		}finally{
			try {
//				if (null != os) {//在文件不存在的情况下   可能是null
					os.close();//关闭资源
//				} 
			} catch (Exception e2) {
				System.out.println("关闭输出流失败");
			}
		}
	}
}
