package testTCP.Chat.demo02;

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
		
		//����ͻ���ʱ˭�Ƚ���˭�Ȳ���
		while(true){
			
			Socket client = server.accept();
			
			//��ȡ����
			DataInputStream dis = new DataInputStream(client.getInputStream());
			//д������
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			//һֱ���տͻ��˷�������Ϣ
			while(true){
				String msg = dis.readUTF();
				dos.writeUTF("���������յ�-->"+msg);
				dos.flush();
			}
		}
	}
}
