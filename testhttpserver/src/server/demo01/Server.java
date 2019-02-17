package server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器(后台)，并启动
 * 只能接受到get方式的，因为是readLine，有空行时后面的就读不到了
 * 
 * @author yinyiliang
 *
 */
public class Server {

	public static void main(String[] args) {
	
		Server server = new Server();
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
			StringBuilder sb = new StringBuilder();
			
			String msg = null;

			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while((msg = br.readLine()).length() > 0){
				sb.append(msg);
				sb.append("\r\n");
				
				if(null==msg){
					break;
				}
				String requestInfo = sb.toString().trim();//去除头尾空格
				//接收客户端的请求信息，网页打开http://localist:8888或运行2.html
				System.out.println(requestInfo);
			}
			
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
