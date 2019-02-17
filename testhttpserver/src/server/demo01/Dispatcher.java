package server.demo01;

import java.io.IOException;
import java.net.Socket;

import utils.CloseUtil;

/**
 * 一个请求与响应 就有一个此对象
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

		Servlet serv = new Servlet();
		serv.service(req, rep);
		
		
//		rep.pushToClient(500);
//		rep.pushToClient(404);
		try {
			rep.pushToClient(code);//推送到客户端
		} catch (IOException e) {
			//e.printStackTrace();
			
		}
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CloseUtil.closeSocket(client);//这样IO流也关了
	}

}
