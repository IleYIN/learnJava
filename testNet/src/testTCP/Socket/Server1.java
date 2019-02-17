package testTCP.Socket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 必须先启动服务器后连接
 * 
 * 不同的协议端口可以重复，所以这里可以用8888
 * 1、创建服务器+指定端口
 * 2、接收客户端的连接 阻塞式
 * 3、发送数据+接收数据
 * 
 * @author yinyiliang
 *
 */
public class Server1 {

	public static void main(String[] args) throws IOException {
		
		//1、创建服务器+指定端口
		ServerSocket server = new ServerSocket(8888);
		//2、接收客户端的连接 阻塞式
		Socket socket = server.accept();
		System.out.println("一个客户端建立连接");
		//浏览器（浏览器也是一个基于tcp传输协议的客户端，http是交互协议），打开http://localhost:8888请求连接
		//服务器已启动时，再启动一次会报异常：端口被占用java.net.BindException: Address already in use: JVM_Bind
		
		//3、发送数据
		String msg = "欢迎使用";
		
		/*
		//输出流 使用缓冲流和转换流包装字符到字节
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()
						)
				);
		bw.write(msg);
		bw.newLine();
		bw.flush();
		//不要关闭bw，因为服务器是不间断服务的
		*/
		
		//可以换流，但是要server和client都换
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//不用关闭dos，服务器是不断服务的
		
	}
	
}
