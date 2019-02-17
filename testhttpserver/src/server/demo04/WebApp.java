package server.demo04;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {

	private static ServletContext contxt;
	static {
		try {
			//��ȡ��������
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//��ȡ������
			SAXParser sax = factory.newSAXParser();
			//ָ��xml+������
			WebHandler webhandler = new WebHandler();
			sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("server/demo04/web.xml"),
					webhandler);
			
			
			//��Listת��Map
			
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
