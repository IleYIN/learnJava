package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试ResultSet
 * 关闭声明 关闭连接
 * 
 * @author yinyiliang
 *
 */
public class Demo04 {

	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			String sql = "select * from users01 where id>?";
			ps = conn.prepareStatement(sql);
			
			ps.setObject(1, 2);//id>2;
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getDate(3)+"---"+rs.getInt(4));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			//注意关闭顺序，而且不能合到一起!! 分开可以不影响后面的关闭的执行！
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
