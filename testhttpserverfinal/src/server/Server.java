package server;

import java.io.IOException;
import java.net.ServerSocket;
import utils.CloseUtil;

/**
 * ����������(��̨)��������
 * ������Ӧ
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
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	private boolean isShutDown = false;
	
	

	/**
	 * ��������
	 */
	public void start(){
		start(8888);
	}
	
	/**
	 * ָ���˿ڵ���������
	 */
	public void start(int port){
		try {
		
			serversocket = new ServerSocket(port);
			this.receive();
			
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	
	/**
	 * ���տͻ���
	 */
	private void receive(){
		try {
			while(!isShutDown) {
				
				//Socket client = serversocket.accept();
				new Thread(new Dispatcher(serversocket.accept())).start();
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	
	/**
	 * ֹͣ������
	 */
	public void stop(){
		isShutDown = true;
		CloseUtil.closeSocket(serversocket);
	}
	
}
