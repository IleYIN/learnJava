package testTCP.Chat.demo01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 * 
 * ��ȡ���ݣ�������
 * д�����ݣ������
 * 
 * @author yinyiliang
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket client = server.accept();
		
		//��ȡ����
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		
		//д������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("���������յ�-->"+msg);
		dos.flush();
	}
}
