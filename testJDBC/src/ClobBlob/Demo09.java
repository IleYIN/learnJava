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
 * ����CLOB�ı������
 * ���ַ������ļ����ݲ������ݿ��е�CLOB�ֶΣ���CLOB�ֶ�ȡ����
 * 
 * CLOB: Character Large Object �����ķ�ʽ����
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
			//����������
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			
			ps = conn.prepareStatement("insert into users01 (username, myinfo) values (?,?)");
			
			ps.setString(1, "����");
			
			/**
			 * �����⣡��������������������������������������
			 * org.postgresql.jdbc4.Jdbc4Connection.setClob(int, Reader)������δ��ʵ��
			 * org.postgresql.util.PSQLException: ����������ֵ long
			 */
			//���ı�����ֱ�����뵽���ݿ���
//			ps.setClob(2, new FileReader(new File("D:/informatique/hello.txt")));
			//�������е��ַ������뵽���ݿ��CLOB�ֶ���
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
			
			//ע��ر�˳�򣬶��Ҳ��ܺϵ�һ��!! �ֿ����Բ�Ӱ�����Ĺرյ�ִ�У�
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
