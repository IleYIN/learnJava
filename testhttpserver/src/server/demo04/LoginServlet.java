package server.demo04;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request req, Response rep) throws Exception {
//		rep.println("<html><head><title>»¶Ó­»ØÀ´</title>");
//		rep.println("</head><body>");
//		rep.println("»¶Ó­").println(req.getParameter("uname")).println("µÇÂ¼");
//		rep.println("</body></html>");
		
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name,pwd)) {
			rep.println("µÇÂ¼³É¹¦");
		} else {
			rep.println("µÇÂ¼Ê§°Ü");
		}
	}
	
	public boolean login(String name, String pwd) {
		return name.equals("yin") && pwd.equals("123456");
	}

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		
	}

}
