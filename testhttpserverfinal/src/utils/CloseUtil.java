package utils;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 关闭流的方法
 * 
 * @author yinyiliang
 *
 */
public class CloseUtil {

	public static void closeIO(Closeable... io){
		for(Closeable temp:io){
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
	public static <T extends Closeable> void closeIO2(T ... io){
		
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
	
	public static void closeSocket(ServerSocket socket){
			try {
				if(null != socket){
				socket.close();
				}
			} catch (Exception e) {
		}
	}
	
	public static void closeSocket(Socket socket){
		try {
			if(null != socket){
				socket.close();
			}
		} catch (Exception e) {
		}
	
	}

	public static void closeSocket(DatagramSocket socket){
		try {
			if(null != socket){
				socket.close();
			}
		} catch (Exception e) {
		}
	}
	
}
