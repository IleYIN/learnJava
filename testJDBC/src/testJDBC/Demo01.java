package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �������ݿ⽨������
 * 
 * @author yinyiliang
 *
 */
public class Demo01 {

	public static void main(String[] args) {
	
		Connection connection = null;
		try {
			//����������
			Class.forName("org.postgresql.Driver");
			
			long start = System.currentTimeMillis();
			
			//�������ӣ����Ӷ����ڲ���ʵ������Socket������һ��Զ�̵����ӣ��ȽϺ�ʱ������Connection��������һ��Ҫ�㣡��
			//���������У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������Ӷ���
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			//"jdbc:postgresql://hostname:port/dbname","username", "password"
			
			long end = System.currentTimeMillis();
			System.out.println(connection + " ���Ӻ�ʱ��ms���� " + (end - start));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
