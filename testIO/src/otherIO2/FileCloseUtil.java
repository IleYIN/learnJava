package otherIO2;

import java.io.Closeable;
import java.io.IOException;

/**
 * ������ر���
 * 
 * @author yinyiliang
 *
 */
public class FileCloseUtil {

	/**
	 * ������ر���
	 */
	public static void close(Closeable ... io){//...��ʾ�ɱ�������������ָ����������������ͣ�ֻ�ܷ����βε����һ��λ�ã�����ʽ������һ��
		
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
	 * ʹ�÷��ͷ���
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
