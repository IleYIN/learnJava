package server.demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ����������(��̨)��������
 * ������Ӧ
 * 
 * @author yinyiliang
 *
 */
public class Server6 {

	public static void main(String[] args) {
	
		Server6 server = new Server6();
		server.start();
	}
	
	private ServerSocket serversocket;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	
	
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
			
			//����
			Request req = new Request(client.getInputStream());

			//��Ӧ
			Response rep = new Response(client.getOutputStream());
			Servlet serv = new Servlet();
			serv.service(req, rep);
			
			
//			rep.pushToClient(500);
//			rep.pushToClient(404);
			rep.pushToClient(200);
			
			
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
