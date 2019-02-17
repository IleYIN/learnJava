package otherIO2;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类关闭流
 * 
 * @author yinyiliang
 *
 */
public class FileCloseUtil {

	/**
	 * 工具类关闭流
	 */
	public static void close(Closeable ... io){//...表示可变参数，个数随便指定但必须是这个类型，只能放在形参的最后一个位置，处理方式和数组一致
		
		for(Closeable temp : io){
			if (null != temp){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 * 使用泛型方法
	 */
	public static <T extends Closeable> void close2(T ... io){
		
		for(T temp : io){
			if (null != temp){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
