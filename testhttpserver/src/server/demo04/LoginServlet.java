package server.demo04;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request req, Response rep) throws Exception {
//		rep.println("<html><head><title>��ӭ����</title>");
//		rep.println("</head><body>");
//		rep.println("��ӭ").println(req.getParameter("uname")).println("��¼");
//		rep.println("</body></html>");
		
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name,pwd)) {
			rep.println("��¼�ɹ�");
		} else {
			rep.println("��¼ʧ��");
		}
	}
	
	public boolean login(String name, String pwd) {
		return name.equals("yin") && pwd.equals("123456");
	}

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		
	}

}
