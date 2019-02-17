package server.reflect;

import server.demo02.Servlet;

/**
 * 创建实例 调用空构造
 * 
 * @author yinyiliang
 *
 */
public class Test02 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("server.demo02.LoginServlet");
		//调用空构造 确保空构造存在
		Servlet ser = (Servlet)clz.newInstance();
//		return ser;
	}
	
}
