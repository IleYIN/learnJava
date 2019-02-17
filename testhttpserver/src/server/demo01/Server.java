package server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������(��̨)��������
 * ֻ�ܽ��ܵ�get��ʽ�ģ���Ϊ��readLine���п���ʱ����ľͶ�������
 * 
 * @author yinyiliang
 *
 */
public class Server {

	public static void main(String[] args) {
	
		Server server = new Server();
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
			StringBuilder sb = new StringBuilder();
			
			String msg = null;

			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while((msg = br.readLine()).length() > 0){
				sb.append(msg);
				sb.append("\r\n");
				
				if(null==msg){
					break;
				}
				String requestInfo = sb.toString().trim();//ȥ��ͷβ�ո�
				//���տͻ��˵�������Ϣ����ҳ��http://localist:8888������2.html
				System.out.println(requestInfo);
			}
			
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
