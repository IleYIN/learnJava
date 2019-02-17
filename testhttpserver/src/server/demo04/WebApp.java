package server.demo04;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {

	private static ServletContext contxt;
	static {
		try {
			//获取解析工厂
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//获取解析器
			SAXParser sax = factory.newSAXParser();
			//指定xml+处理器
			WebHandler webhandler = new WebHandler();
			sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("server/demo04/web.xml"),
					webhandler);
			
			
			//将List转成Map
			
			contxt = new ServletContext();
					
		
			Map<String,String> servlet = contxt.getServlet();
			//servlet-name servlet-class
			
			/* servlet.put("login", "server.demo03.LoginServlet");
			servlet.put("register", "server.demo03.RegisterServlet");*/
			
			
			for(Entity entity:webhandler.getEntityList()) {
				servlet.put(entity.getName(),entity.getCls());
			}
			
			

			Map<String,String> mapping = contxt.getMapping();
			//url-pattern servlet-name
			
			
			
			/*	mapping.put("/login", "login");
			mapping.put("/log", "login");
			mapping.put("/reg", "register"); */
			for(Mapping map:webhandler.getMappingList()) {
				List<String> urls = map.getUrlPattern();
				for(String url:urls) {
					mapping.put(url,map.getName());
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
