package testJDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

/**
 * 测试时间处理（java.sql.Date,Time,Timestamp）
 * 
 * @author yinyiliang
 *
 */
public class Demo07 {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps1 = null;
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			for(int i=0;i<1000;i++) {
				
				String sql1 = "insert into users01 (username,pwd,regtime,lastLoginTime) values (?,?,?,?)";
				ps1 = conn.prepareStatement(sql1);
				
				ps1.setObject(1, "心心"+i);
				ps1.setObject(2, 123456);
				
				int rand = 100000000 + new Random().nextInt(1000000000);
				
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis() - rand);
				ps1.setDate(3, date);
				
//			Timestamp stamp = new Timestamp(2015,10,15,8,15,20,12);
				Timestamp stamp = new Timestamp(System.currentTimeMillis() - rand);//如果需要插入指定日期，可以使用Calendar类、DateFormat
				
				ps1.setTimestamp(4, stamp);
				
				ps1.execute();//事务开始
			}
			
		//	System.out.println("插入一个用户");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			
			//注意关闭顺序，而且不能合到一起!! 分开可以不影响后面的关闭的执行！
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
