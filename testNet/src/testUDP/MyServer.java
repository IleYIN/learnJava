package testUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * 1、创建服务端+端口
 * 2、准备接收容器
 * 3、打包 封装成包
 * 4、接收数据
 * 5、分析数据
 * 6、释放资源
 * 
 * 先启动服务端接收数据 再启动客户端发送数据；否则会造成数据丢失（UDP非面向连接）
 * 
 * @author yinyiliang
 *
 */
public class MyServer {

	public static void main(String[] args) throws IOException {
		//1、创建服务端+端口
		DatagramSocket server = new DatagramSocket(8888);
		//2、准备接收容器
		byte[] container = new byte[10];
		//3、打包 封装成包
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4、接收数据
		server.receive(packet);
		//5、分析数据
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		//6、释放资源
		server.close();
	}
}
