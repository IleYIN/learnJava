package testUDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * �ͻ���
 * 1������ �ͻ���+�˿�
 * 2��׼������ double-->�ֽ����� �����
 * 3�������ָ�����͵ĵص㼰�˿ڣ�
 * 4������
 * 5���ͷ�
 * 
 * 
 * @author yinyiliang
 *
 */
public class MyClient2 {

	public static void main(String[] args) throws IOException {
		
		//1�������ͻ���+�˿�
		DatagramSocket client = new DatagramSocket(6666);//��Ϊ��ͬһ̨�����ϣ��˿ڲ�Ҫ��ͻ
		//2��׼������
		double num =89.12;
		byte[] data = convert(num);
		
		//����ȥ��Ҫ���͵ķ������˿ڶ��������ӵ�ʱ���Ҷ˿�-->����������
		//3�������ָ�����͵ĵص㼰�˿ڣ�DatagramPacket.DatagramPacket(byte[] buf, int length, SocketAddress address)
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//4������
		client.send(packet);
		//5���ͷ�
		client.close();
	}
	
	/**
	 * �ֽ����� ����Դ+Data �����
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException{
		
		byte[] data = null;
		
		//ByteArrayOutputStream���ܶ�̬��Ϊ������������Inputû��
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
		
		dos.writeDouble(num);
		dos.flush();
		
		//��ȡ����
		data = bos.toByteArray();
		dos.close();
//		bos.close();
		return data;
		
	}
}
