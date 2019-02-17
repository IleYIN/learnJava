package testUDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * �����
 * 1�����������+�˿�
 * 2��׼����������
 * 3����� ��װ�ɰ�
 * 4����������
 * 5���������� �ֽ�����-->double
 * 6���ͷ���Դ
 * 
 * 
 * ����������˽������� �������ͻ��˷������ݣ������������ݶ�ʧ��UDP���������ӣ�
 * @author yinyiliang
 *
 */
public class MyServer2 {

	public static void main(String[] args) throws IOException {
		//1�����������+�˿�
		DatagramSocket server = new DatagramSocket(8888);
		//2��׼����������
		byte[] container = new byte[10];
		//3����� ��װ�ɰ�
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4����������
		server.receive(packet);
		//5����������
		double data = convert(packet.getData());
		int len = packet.getLength();
		System.out.println(data);
		//6���ͷ���Դ
		server.close();
	}
	
	
	/**
	 * �ֽ�����+Data������
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	public static double convert(byte[] data) throws IOException{
		
		//ByteArrayOutputStream���ܶ�̬��Ϊ������������Inputû��
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
		double num = dis.readDouble();
		return num;
	}
}
