package server.demo01;

public class Servlet {

	public void service(Request req, Response rep) {

		rep.println("<html><head><title>HTTP��Ӧʵ��</title>");
		rep.println("</head><body>");
		rep.println("��ӭ").println(req.getParameter("uname")).println("��¼");
		rep.println("</body></html>");
		
	}
}
