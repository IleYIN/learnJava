package testUDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 * 1、创建服务端+端口
 * 2、准备接收容器
 * 3、打包 封装成包
 * 4、接收数据
 * 5、分析数据 字节数组-->double
 * 6、释放资源
 * 
 * 
 * 先启动服务端接收数据 再启动客户端发送数据；否则会造成数据丢失（UDP非面向连接）
 * @author yinyiliang
 *
 */
public class MyServer2 {

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
		double data = convert(packet.getData());
		int len = packet.getLength();
		System.out.println(data);
		//6、释放资源
		server.close();
	}
	
	
	/**
	 * 字节数组+Data输入流
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	public static double convert(byte[] data) throws IOException{
		
		//ByteArrayOutputStream不能多态因为有新增方法，Input没事
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
		double num = dis.readDouble();
		return num;
	}
}
