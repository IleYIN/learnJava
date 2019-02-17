package server.demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器(后台)，并启动
 * 请求并响应
 * 
 * @author yinyiliang
 *
 */
public class Server6 {

	public static void main(String[] args) {
	
		Server6 server = new Server6();
		server.start();
	}
	
	private ServerSocket serversocket;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	
	
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
			
			//请求
			Request req = new Request(client.getInputStream());

			//响应
			Response rep = new Response(client.getOutputStream());
			Servlet serv = new Servlet();
			serv.service(req, rep);
			
			
//			rep.pushToClient(500);
//			rep.pushToClient(404);
			rep.pushToClient(200);
			
			
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
