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
public class Server4 {

	public static void main(String[] args) {
	
		Server4 server = new Server4();
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
		

			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			//接收客户端的请求信息
			//运行2.html，或输网址默认get方式http://localhost:8888/index.html?name=yinypwd=1234
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			//响应
			Response rep = new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP响应实例</title></head><body>Hello Server!</body></html>");
			rep.pushToClient(500);
//			rep.pushToClient(404);
//			rep.pushToClient(200);
			
			
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
