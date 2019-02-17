package ClobBlob;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 测试BLOB 二进制大对象
 * 将字符串、文件内容插入数据库中的CLOB字段，将CLOB字段取出来
 * 
 * CLOB: Character Large Object 以流的方式处理
 * BLOB: Binary Large Object
 * 
 * @author yinyiliang
 * 
 *
 */


public class Demo10{

	public static void main(String[] args)  {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");

			//			ps = conn.prepareStatement("insert into users01 (username, headimg) values (?,?)");
			//			
			//			ps.setString(1, "哈哈");
			//			ps.setBlob(2, new FileInputStream("C:\\Users\\yinyiliang\\Pictures\\flags\\china.png"));
			//			
			//			ps.execute();
			//			
			/**
			 * setBlob有问题
			 * org.postgresql.util.PSQLException: 大型对象无法被使用在自动确认事物交易模式。
			 */


			ps = conn.prepareStatement("select * from users01 where id = ?");
			ps.setObject(1, 335);

			rs = ps.executeQuery();

			while(rs.next()) {

				Blob b = rs.getBlob("headimg");
				is = b.getBinaryStream();
				os = new FileOutputStream("D:/a.png");
				
				int temp = 0;

				while((temp = is.read())!=-1) {
					System.out.println((char)temp);
					os.write(temp);
				}

			}			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			//注意关闭顺序，而且不能合到一起!! 分开可以不影响后面的关闭的执行！
			try {
				if (is!=null) {
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (os!=null) {
					os.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
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
