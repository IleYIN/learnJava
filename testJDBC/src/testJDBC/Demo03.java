package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����PreparedStatement
 * 
 * @author yinyiliang
 *
 */
public class Demo03 {

	public static void main(String[] args) {
	
		Connection conn = null;
		
		try {
			//����������
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			String sql = "insert into users01 (username, id, regtime) values (?,?,?)";//?ռλ����Ԥ������ֹsqlע��
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setString(1, "����");//����������1��ʼ��
			//ps.setInt(2, 11);
			
			//������setObject�������ݲ���������д��������
			ps.setObject(1, "����");
			ps.setObject(2, 15);
//			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			
			System.out.println("����һ�м�¼");
//			ps.execute();//boolean
			int count = ps.executeUpdate();//����Ӱ���˶����м�¼������insert/update/delete
			System.out.println(count);//executeQuery����select������ResultSet�����
			
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
