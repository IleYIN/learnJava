package byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 * 注意文件夹是不能用流读取的
 * 
 * 
 * @author yiny
 *
 */
public class Test01Read {

	public static void main(String[] args) {
		
		//建立联系 File对象
		File src = new File("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
		
		//选择流
		InputStream is = null;//提升作用域
		try {
			is = new FileInputStream(src);
//			InputStream is = new FileInputStream("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
			
			//操作不断读取 缓冲数组
			byte[] car = new byte[10];
			int len = 0; //接收 实际读取大小
			
			//循环读取如果读到没有了ins.read(car)的取值为-1    
			while(-1 != (len = is.read(car))){
				//输出 字节数组转成字符串
				String info = new String(car,0,len);
				System.out.println(info);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读取文件失败");
			e.printStackTrace();
		}finally{ //释放资源
			
				try {
					if (null != is){//在文件不存在的情况下   is有可能是null
						is.close();
					}
				} catch (Exception e2) {//选中if那几行  按alt+shift+z-->try catch block
					System.out.println("关闭文件输入流失败");
				}
			
		}
	}
}
