package testPolymorphismServlet;

public class TestServlet {
	public static void main(String[] args) {
		HttpServlet s = new MyServlet();
		s.service();  
		//这里出来的是MyServlet的doGet因为所有的this指向当前对象即调用该方法的对象，即MyServlet，而里面没有service采用的Http的service
	}
}
