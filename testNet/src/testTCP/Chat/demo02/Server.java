package testTCP.Chat.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 
 * 读取数据：输入流
 * 写出数据：输出流
 * 
 * @author yinyiliang
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		
		//多个客户端时谁先进来谁先操作
		while(true){
			
			Socket client = server.accept();
			
			//读取数据
			DataInputStream dis = new DataInputStream(client.getInputStream());
			//写出数据
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			//一直接收客户端发来的信息
			while(true){
				String msg = dis.readUTF();
				dos.writeUTF("服务器已收到-->"+msg);
				dos.flush();
			}
		}
	}
}
