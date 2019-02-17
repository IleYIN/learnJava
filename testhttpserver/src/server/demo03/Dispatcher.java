package server.demo03;

import java.io.IOException;
import java.net.Socket;

import utils.CloseUtil;

/**
 * һ����������Ӧ ����һ���˶���
 * 
 * @author yinyiliang
 *
 */
public class Dispatcher implements Runnable {

	private Socket client;
	private Request req;
	private Response rep;
	private int code = 200;

	Dispatcher(Socket client) {
		this.client = client;
		try {
			req = new Request(client.getInputStream());
			rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			code = 500;
			return;
		}
	}

	@Override
	public void run() {
		try {
			Servlet serv = WebApp.getServlet(req.getUrl());
			if(null==serv) {
				this.code = 404;//�Ҳ�������
			} else {
				serv.service(req, rep);
			}
			rep.pushToClient(code);//���͵��ͻ���
		} catch (Exception e) {
			//e.printStackTrace();
			this.code = 500;
		}
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		CloseUtil.closeSocket(client);//����IO��Ҳ����
	}

}
