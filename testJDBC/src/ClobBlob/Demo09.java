package ClobBlob;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 测试CLOB文本大对象
 * 将字符串、文件内容插入数据库中的CLOB字段，将CLOB字段取出来
 * 
 * CLOB: Character Large Object 以流的方式处理
 * BLOB: Binary Large Object
 * 
 * @author yinyiliang
 * 
 *
 */


public class Demo09{
	
	public static void main(String[] args)  {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r = null;
		
		try {
			//加载驱动类
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			ps = conn.prepareStatement("insert into users01 (username, myinfo) values (?,?)");
			
			ps.setString(1, "处男");
			
			/**
			 * 有问题！！！！！！！！！！！！！！！！！！！！
			 * org.postgresql.jdbc4.Jdbc4Connection.setClob(int, Reader)方法尚未被实作
			 * org.postgresql.util.PSQLException: 不良的类型值 long
			 */
			//将文本内容直接输入到数据库中
//			ps.setClob(2, new FileReader(new File("D:/informatique/hello.txt")));
			//将程序中的字符串输入到数据库的CLOB字段中
//			ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaaaaa".getBytes()))));
			
			ps = conn.prepareStatement("select * from users01 where id = ?");
			ps.setObject(1, 335);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Clob c = rs.getClob("myinfo");
				r = c.getCharacterStream();
				
				int temp = 0;
				try {
					while((temp = r.read())!=-1) {
						System.out.println((char)temp);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
//			
//			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			
			//注意关闭顺序，而且不能合到一起!! 分开可以不影响后面的关闭的执行！
			try {
				if (r!=null) {
					r.close();
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
