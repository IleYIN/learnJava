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
public class Server5 {

	public static void main(String[] args) {
	
		Server5 server = new Server5();
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
			rep.println("<html><head><title>HTTP��Ӧʵ��</title>");
			rep.println("</head><body>");
			rep.println("��ӭ").println(req.getParameter("uname")).println("��¼");
			rep.println("</body></html>");
			
			
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
