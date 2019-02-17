package server.demo01;

public class Servlet {

	public void service(Request req, Response rep) {

		rep.println("<html><head><title>HTTPÏìÓ¦ÊµÀı</title>");
		rep.println("</head><body>");
		rep.println("»¶Ó­").println(req.getParameter("uname")).println("µÇÂ¼");
		rep.println("</body></html>");
		
	}
}
