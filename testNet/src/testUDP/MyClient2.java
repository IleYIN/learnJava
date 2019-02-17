package testUDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 * 1、创建 客户端+端口
 * 2、准备数据 double-->字节数组 输出流
 * 3、打包（指定发送的地点及端口）
 * 4、发送
 * 5、释放
 * 
 * 
 * @author yinyiliang
 *
 */
public class MyClient2 {

	public static void main(String[] args) throws IOException {
		
		//1、创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);//因为在同一台电脑上，端口不要冲突
		//2、准备数据
		double num =89.12;
		byte[] data = convert(num);
		
		//数据去找要发送的服务器端口而不是连接的时候找端口-->非面向连接
		//3、打包（指定发送的地点及端口）DatagramPacket.DatagramPacket(byte[] buf, int length, SocketAddress address)
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//4、发送
		client.send(packet);
		//5、释放
		client.close();
	}
	
	/**
	 * 字节数组 数据源+Data 输出流
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException{
		
		byte[] data = null;
		
		//ByteArrayOutputStream不能多态因为有新增方法，Input没事
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
		
		dos.writeDouble(num);
		dos.flush();
		
		//获取数据
		data = bos.toByteArray();
		dos.close();
//		bos.close();
		return data;
		
	}
}
