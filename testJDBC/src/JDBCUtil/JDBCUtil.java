package JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	static Properties pros = null; //可以帮助读取和处理资源文件中的信息

	static { //加载JDBCUtil类的时候调用，只会在加载时被执行一次
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getPostgreConn () {
		Connection conn = null;
		try {
//			Class.forName("org.postgresql.Driver");
			Class.forName(pros.getProperty("postgresqlDriver"));
//			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			conn = DriverManager.getConnection(pros.getProperty("postgresqlURL"), pros.getProperty("postgresqlUser"), pros.getProperty("postgresqlPwd"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void close(ResultSet rs, Statement ps, Connection conn) {
		
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
	
	public static void close(Statement ps, Connection conn) {
		
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
	
	public static void close(Connection conn) {
		
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
