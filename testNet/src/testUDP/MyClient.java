package testUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * 客户端
 * 1、创建 客户端+端口
 * 2、准备数据
 * 3、打包（指定发送的地点及端口）
 * 4、发送
 * 5、释放
 * 
 * 
 * @author yinyiliang
 *
 */
public class MyClient {

	public static void main(String[] args) throws IOException {
		
		//1、创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);//因为在同一台电脑上，端口不要冲突
		//2、准备数据
		String msg = "udp编程";
		byte[] data = msg.getBytes();
		
		//数据去找要发送的服务器端口而不是连接的时候找端口-->非面向连接
		//3、打包（指定发送的地点及端口）DatagramPacket.DatagramPacket(byte[] buf, int length, SocketAddress address)
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//4、发送
		client.send(packet);
		//5、释放
		client.close();
	}
}
