package server.demo02;

import java.util.Map;

public class WebApp {

	private static ServletContext contxt;
	static {
		contxt = new ServletContext();
		
		Map<String,String> mapping = contxt.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String,String> servlet = contxt.getServlet();
		servlet.put("login", "testhttpserver.src.server.demo02.LoginServlet");
		servlet.put("register", "testhttpserver.src.server.demo02.RegisterServlet");
	}

	public static Servlet getServlet(String url) {
		
		if(url.trim().equals("")||(null==url)) {
			return null;
		} 
		
		
		//Map<String,String>����� �����ַ���������·������������
		return null;
		
		
		//Map<String,Servlet>�����
		//return contxt.getServlet().get(contxt.getMapping().get(url));
		//getMapping().get(url)�ǵõ�url��Ӧ��ֵ
		//getServlet().get()�ǵõ���Ӧ��Servlet
		
	}
}
