package testTCP.Socket;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1�������ͻ��ˣ������ƶ�������+�˿ڣ���ʱ��������
 * 2����������+��������
 * 
 * 
 * 
 * Console --> scroll lock����Ҫ�鿴�Ŀ���̨
 * 
 * 
 * @author yinyiliang
 *
 */
public class Client1 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1�������ͻ��ˣ�����ָ��������+�˿ڣ���ʱ����������Ķ˿�����
		//Socket(String host, int port)
		Socket client = new Socket("localhost",8888);
		//tcp����Ҫ����ͻ��˵Ķ˿ڣ����Զ����䣬udp��Ҫ�Լ�ָ��
		//��������ֹͣʱ������ʱ�ᱨ�� java.net.ConnectException: Connection refused: connect
		
		//2����������  ʹ�û�������ת������װ�ֽڵ��ַ�
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();//���ж�ȡ������ʽ������������Ϣ��Ҫ���н�����
		System.out.println(echo);
		*/
		
		//���Ի���������Ҫserver��client����
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	}
}
