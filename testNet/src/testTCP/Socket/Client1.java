package testTCP.Socket;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1、创建客户端，必须制定服务器+端口，此时就在连接
 * 2、接收数据+发送数据
 * 
 * 
 * 
 * Console --> scroll lock锁定要查看的控制台
 * 
 * 
 * @author yinyiliang
 *
 */
public class Client1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、创建客户端，必须指定服务器+端口，此时就与服务器的端口连接
		//Socket(String host, int port)
		Socket client = new Socket("localhost",8888);
		//tcp不需要分配客户端的端口，会自动分配，udp则要自己指定
		//当服务器停止时，运行时会报错 java.net.ConnectException: Connection refused: connect
		
		//2、接收数据  使用缓冲流和转换流包装字节到字符
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();//逐行读取，阻塞式方法，所读信息需要有行结束符
		System.out.println(echo);
		*/
		
		//可以换流，但是要server和client都换
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	}
}
