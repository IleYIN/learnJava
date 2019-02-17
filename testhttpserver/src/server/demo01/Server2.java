package server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������(��̨)��������
 * �ĳ���byte���գ��Ͻ�����Ӧ��һ���ֽ�һ���ֽڶ�
 * 
 * @author yinyiliang
 *
 */
public class Server2 {

	public static void main(String[] args) {
	
		Server2 server = new Server2();
		server.start();
	}
	
	private ServerSocket serversocket;
	
	
	/**
	 * ��������
	 */
	public void start(){
		try {
			serversocket = new ServerSocket(8888);
			this.receive();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/**
	 * ���տͻ���
	 */
	private void receive(){
		try {
			Socket client = serversocket.accept();
//			StringBuilder sb = new StringBuilder();
			
//			String msg = null;

			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			//���տͻ��˵�������Ϣ
			//����2.html��������ַĬ��get��ʽhttp://localhost:8888/index.html?name=yinypwd=1234
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ֹͣ������
	 */
	public void stop(){
		
	}
	
}
