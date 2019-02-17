package server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器(后台)，并启动
 * 改成用byte接收，严谨来讲应该一个字节一个字节读
 * 
 * @author yinyiliang
 *
 */
public class Server2 {

	public static void main(String[] args) {
	
		Server2 server = new Server2();
		server.start();
	}
	
	private ServerSocket serversocket;
	
	
	/**
	 * 启动方法
	 */
	public void start(){
		try {
			serversocket = new ServerSocket(8888);
			this.receive();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/**
	 * 接收客户端
	 */
	private void receive(){
		try {
			Socket client = serversocket.accept();
//			StringBuilder sb = new StringBuilder();
			
//			String msg = null;

			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			//接收客户端的请求信息
			//运行2.html，或输网址默认get方式http://localhost:8888/index.html?name=yinypwd=1234
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 停止服务器
	 */
	public void stop(){
		
	}
	
}
