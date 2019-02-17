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
		
		
		//Map<String,String>的情况 根据字符串（完整路径）创建对象  如server.demo03.LoginServlet
		String name = contxt.getServlet().get(contxt.getMapping().get(url));
		//反射 用Class对象创建新的对象
		return (Servlet) Class.forName(name).newInstance();//确保空构造存在
		
		//Map<String,Servlet>的情况
		//return contxt.getServlet().get(contxt.getMapping().get(url));
		//getMapping().get(url)是得到url对应的值
		//getServlet().get()是得到对应的Servlet
		
	}
}
