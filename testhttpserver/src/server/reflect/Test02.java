package server.reflect;

import server.demo02.Servlet;

/**
 * ����ʵ�� ���ÿչ���
 * 
 * @author yinyiliang
 *
 */
public class Test02 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("server.demo02.LoginServlet");
		//���ÿչ��� ȷ���չ������
		Servlet ser = (Servlet)clz.newInstance();
//		return ser;
	}
	
}
