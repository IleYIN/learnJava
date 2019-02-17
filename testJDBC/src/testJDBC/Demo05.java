package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �������������ڴ����ģ�����PreparedStatement��ΪԤ����ռ����ޣ�����ʱ�ᷢ���쳣
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
			//����������
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			conn.setAutoCommit(false);//Ĭ��Ϊtrue���������ó�false�ֶ��ύ
			
			long start = System.currentTimeMillis();
			stmt = conn.createStatement();
			
			for(int i=0;i<200;i++) {
				stmt.addBatch("insert into users01 (username,pwd, regtime) values ('��Ա"+i+"',"+i+",now())");
			}
			
			stmt.executeBatch();
			
			conn.commit();//�ύ����
			
			long end = System.currentTimeMillis();
			System.out.println("ִ����ʱ��ms����"+(end-start));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			//ע��ر�˳�򣬶��Ҳ��ܺϵ�һ��!! �ֿ����Բ�Ӱ�����Ĺرյ�ִ�У�
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
