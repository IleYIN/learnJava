package testJDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * ����ʱ�䴦��java.sql.Date,Time,Timestamp��
 * ȡ��ָ��ʱ��ε�����
 * 
 * @author yinyiliang
 *
 */
public class Demo08 {
	
	/**
	 * ���ַ������������ת��Ϊlong���֣���ʽ��yyyy-MM-dd hh:mm:ss��
	 * @param dateStr
	 * @return
	 */
	public static long str2Date(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			//����������
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");

//			ps = conn.prepareStatement("select * from users01 where regTime>? and regTime<?");
//			
//			java.sql.Date start = new java.sql.Date(str2Date("2018-11-28 10:23:45"));
//			java.sql.Date end = new java.sql.Date(str2Date("2018-11-30 10:23:45"));
//			
//			ps.setObject(1, start);
//			ps.setObject(2, end);
			
			ps = conn.prepareStatement("select * from users01 where lastlogintime>? and lastlogintime<? order by lastlogintime");
			Timestamp start = new Timestamp(str2Date("2018-11-19 10:10:10"));
			Timestamp end = new Timestamp(str2Date("2018-11-19 20:20:10"));
			
			ps.setObject(1, start);
			ps.setObject(2, end);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getTimestamp("lastlogintime"));
			}
			
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getDate("regtime"));
//			}
//			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			
			//ע��ر�˳�򣬶��Ҳ��ܺϵ�һ��!! �ֿ����Բ�Ӱ�����Ĺرյ�ִ�У�
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
