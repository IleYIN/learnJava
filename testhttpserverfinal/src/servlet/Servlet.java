package servlet;

import server.Request;
import server.Response;

/**
 * 
 * 抽象成一个父类
 * @author yinyiliang
 *
 */
public abstract class Servlet {

	public void service(Request req, Response rep) throws Exception {
		
		this.doGet(req, rep);
		this.doPost(req, rep);
	}
	
	protected abstract void doGet(Request req, Response rep) throws Exception;
	protected abstract void doPost(Request req, Response rep) throws Exception;
	
}
