package testJDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试事务
 * 
 * @author yinyiliang
 *
 */
public class Demo06 {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			conn.setAutoCommit(false);//JDBC里默认是true
			
			
			String sql1 = "insert into users01 (username,pwd) values (?,?)";
			ps1 = conn.prepareStatement(sql1);
			
			ps1.setObject(1, "宝宝");
			ps1.setObject(2, 123456);
			
			ps1.execute();//事务开始
			System.out.println("插入一个用户：宝宝");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			String sql2 = "insert into users01 (username,pwd) values (?,?)";
			ps2 = conn.prepareStatement(sql1);
			
			ps2.setObject(1, "处男");
			ps2.setObject(2, 123456);
			
			ps2.execute();
			System.out.println("插入一个用户：处男");
			
			conn.commit();//最后提交，则两条语句一起成功，一起失败（回滚操作）
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			
			//注意关闭顺序，而且不能合到一起!! 分开可以不影响后面的关闭的执行！
			try {
				if (ps2!=null) {
					ps2.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps1!=null) {
					ps1.close();
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
