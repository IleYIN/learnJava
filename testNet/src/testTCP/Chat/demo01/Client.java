package testTCP.Chat.demo01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端：发送+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 
 * 问题
 * 输入流与输出流在同一个线程内 彼此应该独立才行
 * 
 * @author yinyiliang
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		
		//控制台输入流
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			
			String info = console.readLine();
			
			//输出流
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(info);
			dos.flush();
			
			//输入流
			DataInputStream dis = new DataInputStream(client.getInputStream());
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}
}
