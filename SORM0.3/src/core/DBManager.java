package core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import bean.Configuration;
import pool.DBConnPool;

/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @author yinyiliang
 *
 */
public class DBManager {
	
	/**
	 * 配置信息
	 */

	private static Configuration conf;//全局
	
	/**
	 * 连接池对象
	 */
	private static DBConnPool pool;
	
	static { //静态代码块只在类加载时执行一次
		Properties pros = new Properties();
		
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));//string-->int
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		
		//加载TableContext
		System.out.println(TableContext.class);
	}
	
	/**
	 * 获得Connection对象
	 * @return 
	 */
	public static Connection getConn() {
		
		if(pool==null) {
			 pool = new DBConnPool();
		}
		return pool.getConnection();
	}
	
	
	/**
	 * 创建Connection对象
	 * @return 
	 */
	public static Connection createConn() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(), conf.getUser(), conf.getPwd());
			//目前直接建立连接，后期增加连接池处理，提高效率！！
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得configuration对象
	 * @return 
	 */
	public static Configuration getConf() {
		return conf;
	}
	
	/**
	 * 关闭传入的ResultSet, PreparedStatement, Connection对象
	 * @param rs
	 * @param ps
	 * @param conn
	 */
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
//		try {
//			if (conn!=null) {
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		pool.close(conn);
	}
	
	public static void close(Statement ps, Connection conn) {
		
		try {
			if (ps!=null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		try {
//			if (conn!=null) {
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		pool.close(conn);
	}
	
	public static void close(Connection conn) {
		
//		try {
//			if (conn!=null) {
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		pool.close(conn);
	}
}
