package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试Statement接口
 * 
 * @author yinyiliang
 *
 */
public class Demo02 {

	public static void main(String[] args) {
	
		Connection connection = null;
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			
			
			//建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象！
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			//"jdbc:postgresql://hostname:port/dbname","username", "password"
			
			//statement不方便，而且容易发生注入危险
			Statement stmt = connection.createStatement();
			String sql = "insert into users01 (username, pwd, regTime, id) values ('王也',555,now(),10)";
			stmt.execute(sql);
			
			//测试SQL注入
//			String id = "5";
//			String id = "5 or 1=1";永远true，会删掉所有
//			String sql = "delete from users01 whre id ="+id;
			
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
