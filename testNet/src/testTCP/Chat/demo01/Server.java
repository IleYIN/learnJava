package testTCP.Chat.demo01;

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
		Socket client = server.accept();
		
		//读取数据
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		
		//写出数据
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("服务器已收到-->"+msg);
		dos.flush();
	}
}
