package testPolymorphismServlet;

public class TestServlet {
	public static void main(String[] args) {
		HttpServlet s = new MyServlet();
		s.service();  
		//�����������MyServlet��doGet��Ϊ���е�thisָ��ǰ���󼴵��ø÷����Ķ��󣬼�MyServlet��������û��service���õ�Http��service
	}
}
