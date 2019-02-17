package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试PreparedStatement
 * 
 * @author yinyiliang
 *
 */
public class Demo03 {

	public static void main(String[] args) {
	
		Connection conn = null;
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			String sql = "insert into users01 (username, id, regtime) values (?,?,?)";//?占位符，预处理，防止sql注入
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setString(1, "老青");//参数索引从1开始算
			//ps.setInt(2, 11);
			
			//可以用setObject方法传递参数，避免写各种类型
			ps.setObject(1, "灵玉");
			ps.setObject(2, 15);
//			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			
			System.out.println("插入一行记录");
//			ps.execute();//boolean
			int count = ps.executeUpdate();//更新影响了多少行记录，用于insert/update/delete
			System.out.println(count);//executeQuery用于select，返回ResultSet结果集
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
