package JDBCUtil;

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
 * 测试使用JDBCUtil简化开发
 * 
 * @author yinyiliang
 * 
 *
 */


public class Demo11{

	public static void main(String[] args)  {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getPostgreConn();
			ps = conn.prepareStatement("insert into users01 (username) values (?)");
			ps.setString(1, "小名");
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
		} finally {

			JDBCUtil.close(rs, ps, conn);
		}
	}
}
