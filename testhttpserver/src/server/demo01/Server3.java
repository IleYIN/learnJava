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
public class Server3 {

	public static void main(String[] args) {
	
		Server3 server = new Server3();
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
		

			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			
			//���տͻ��˵�������Ϣ
			//����2.html��������ַĬ��get��ʽhttp://localhost:8888/index.html?name=yinypwd=1234
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			//��Ӧ
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP��Ӧʵ��</title></head><body>Hello World!</body></html>");
//			responseContext.append("1234");
			
			StringBuilder response = new StringBuilder();
			//1��HTTPЭ��汾 ״̬���� ����
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2����Ӧͷ��Response Head��
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			
			//html����
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//���ı�����
//			response.append("Content-type:text/plain;charset=GBK").append(CRLF);
			//���ĳ���:�ֽڳ���
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//3������֮ǰ
			response.append(CRLF);
			//4������
			response.append(responseContext);
			
			//�����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
			
			
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
