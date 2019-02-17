package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试数据库建立连接
 * 
 * @author yinyiliang
 *
 */
public class Demo01 {

	public static void main(String[] args) {
	
		Connection connection = null;
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			
			long start = System.currentTimeMillis();
			
			//建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象！
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			//"jdbc:postgresql://hostname:port/dbname","username", "password"
			
			long end = System.currentTimeMillis();
			System.out.println(connection + " 连接耗时（ms）： " + (end - start));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
