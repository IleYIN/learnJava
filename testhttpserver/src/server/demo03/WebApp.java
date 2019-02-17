package server.demo03;

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
		servlet.put("login", "server.demo03.LoginServlet");
		servlet.put("register", "server.demo03.RegisterServlet");
	}

	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		if(((url=url.trim()).equals(""))||(null==url)) {
			return null;
		} 
		
		
		//Map<String,String>����� �����ַ���������·������������  ��server.demo03.LoginServlet
		String name = contxt.getServlet().get(contxt.getMapping().get(url));
		//���� ��Class���󴴽��µĶ���
		return (Servlet) Class.forName(name).newInstance();//ȷ���չ������
		
		//Map<String,Servlet>�����
		//return contxt.getServlet().get(contxt.getMapping().get(url));
		//getMapping().get(url)�ǵõ�url��Ӧ��ֵ
		//getServlet().get()�ǵõ���Ӧ��Servlet
		
	}
}
