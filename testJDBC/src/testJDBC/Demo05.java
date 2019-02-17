package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试批处理，对于大量的，不用PreparedStatement因为预编译空间有限，量大时会发生异常
 * 
 * @author yinyiliang
 *
 */
public class Demo05 {

	public static void main(String[] args) {
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			conn.setAutoCommit(false);//默认为true，这里设置成false手动提交
			
			long start = System.currentTimeMillis();
			stmt = conn.createStatement();
			
			for(int i=0;i<200;i++) {
				stmt.addBatch("insert into users01 (username,pwd, regtime) values ('成员"+i+"',"+i+",now())");
			}
			
			stmt.executeBatch();
			
			conn.commit();//提交操作
			
			long end = System.currentTimeMillis();
			System.out.println("执行用时（ms）："+(end-start));
			
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
				if (stmt!=null) {
					stmt.close();
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
