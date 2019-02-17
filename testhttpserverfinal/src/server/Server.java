package server;

import java.io.IOException;
import java.net.ServerSocket;
import utils.CloseUtil;

/**
 * 创建服务器(后台)，并启动
 * 请求并响应
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
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	private boolean isShutDown = false;
	
	

	/**
	 * 启动方法
	 */
	public void start(){
		start(8888);
	}
	
	/**
	 * 指定端口的启动方法
	 */
	public void start(int port){
		try {
		
			serversocket = new ServerSocket(port);
			this.receive();
			
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	
	/**
	 * 接收客户端
	 */
	private void receive(){
		try {
			while(!isShutDown) {
				
				//Socket client = serversocket.accept();
				new Thread(new Dispatcher(serversocket.accept())).start();
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	
	/**
	 * 停止服务器
	 */
	public void stop(){
		isShutDown = true;
		CloseUtil.closeSocket(serversocket);
	}
	
}
