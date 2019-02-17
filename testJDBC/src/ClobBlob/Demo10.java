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
 * ����BLOB �����ƴ����
 * ���ַ������ļ����ݲ������ݿ��е�CLOB�ֶΣ���CLOB�ֶ�ȡ����
 * 
 * CLOB: Character Large Object �����ķ�ʽ����
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
			//����������
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");

			//			ps = conn.prepareStatement("insert into users01 (username, headimg) values (?,?)");
			//			
			//			ps.setString(1, "����");
			//			ps.setBlob(2, new FileInputStream("C:\\Users\\yinyiliang\\Pictures\\flags\\china.png"));
			//			
			//			ps.execute();
			//			
			/**
			 * setBlob������
			 * org.postgresql.util.PSQLException: ���Ͷ����޷���ʹ�����Զ�ȷ�����ｻ��ģʽ��
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

			//ע��ر�˳�򣬶��Ҳ��ܺϵ�һ��!! �ֿ����Բ�Ӱ�����Ĺرյ�ִ�У�
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
