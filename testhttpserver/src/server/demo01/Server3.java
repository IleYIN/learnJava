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
public class Server3 {

	public static void main(String[] args) {
	
		Server3 server = new Server3();
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
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP响应实例</title></head><body>Hello World!</body></html>");
//			responseContext.append("1234");
			
			StringBuilder response = new StringBuilder();
			//1、HTTP协议版本 状态代码 描述
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2、响应头（Response Head）
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			
			//html类型
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//纯文本类型
//			response.append("Content-type:text/plain;charset=GBK").append(CRLF);
			//正文长度:字节长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//3、正文之前
			response.append(CRLF);
			//4、正文
			response.append(responseContext);
			
			//输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
			
			
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
