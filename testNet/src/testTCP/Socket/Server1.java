package testTCP.Socket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������������
 * 
 * ��ͬ��Э��˿ڿ����ظ����������������8888
 * 1������������+ָ���˿�
 * 2�����տͻ��˵����� ����ʽ
 * 3����������+��������
 * 
 * @author yinyiliang
 *
 */
public class Server1 {

	public static void main(String[] args) throws IOException {
		
		//1������������+ָ���˿�
		ServerSocket server = new ServerSocket(8888);
		//2�����տͻ��˵����� ����ʽ
		Socket socket = server.accept();
		System.out.println("һ���ͻ��˽�������");
		//������������Ҳ��һ������tcp����Э��Ŀͻ��ˣ�http�ǽ���Э�飩����http://localhost:8888��������
		//������������ʱ��������һ�λᱨ�쳣���˿ڱ�ռ��java.net.BindException: Address already in use: JVM_Bind
		
		//3����������
		String msg = "��ӭʹ��";
		
		/*
		//����� ʹ�û�������ת������װ�ַ����ֽ�
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()
						)
				);
		bw.write(msg);
		bw.newLine();
		bw.flush();
		//��Ҫ�ر�bw����Ϊ�������ǲ���Ϸ����
		*/
		
		//���Ի���������Ҫserver��client����
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//���ùر�dos���������ǲ��Ϸ����
		
	}
	
}
