package server;

import java.util.HashMap;
import java.util.Map;

/**
 * ������
 * @author yinyiliang
 *
 */
public class ServletContext {
	//Ϊÿһ��servletȡ������
	//login --> LoginServlet
	
	//private Map<String,Servlet> servlet;
	//�����Ŀռ䣬�ĳ��ַ�����login -->testhttpserver.src.server.demo02.LoginServlet
		
	private Map<String,String> servlet;
	
	//url-->login
	// /log -->login
	// /login -->login
	private Map<String,String> mapping;
	
	ServletContext(){
		servlet = new HashMap<String,String>();
		mapping = new HashMap<String,String>();
	}

	public Map<String, String> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	
	
	
}
