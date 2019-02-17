package testJDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��������
 * 
 * @author yinyiliang
 *
 */
public class Demo06 {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		try {
			//����������
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			conn.setAutoCommit(false);//JDBC��Ĭ����true
			
			
			String sql1 = "insert into users01 (username,pwd) values (?,?)";
			ps1 = conn.prepareStatement(sql1);
			
			ps1.setObject(1, "����");
			ps1.setObject(2, 123456);
			
			ps1.execute();//����ʼ
			System.out.println("����һ���û�������");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			String sql2 = "insert into users01 (username,pwd) values (?,?)";
			ps2 = conn.prepareStatement(sql1);
			
			ps2.setObject(1, "����");
			ps2.setObject(2, 123456);
			
			ps2.execute();
			System.out.println("����һ���û�������");
			
			conn.commit();//����ύ�����������һ��ɹ���һ��ʧ�ܣ��ع�������
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			conn.rollback();
			
		} finally {
			
			//ע��ر�˳�򣬶��Ҳ��ܺϵ�һ��!! �ֿ����Բ�Ӱ�����Ĺرյ�ִ�У�
			try {
				if (ps2!=null) {
					ps2.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
