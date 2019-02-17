package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����Statement�ӿ�
 * 
 * @author yinyiliang
 *
 */
public class Demo02 {

	public static void main(String[] args) {
	
		Connection connection = null;
		
		try {
			//����������
			Class.forName("org.postgresql.Driver");
			
			
			//�������ӣ����Ӷ����ڲ���ʵ������Socket������һ��Զ�̵����ӣ��ȽϺ�ʱ������Connection��������һ��Ҫ�㣡��
			//���������У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������Ӷ���
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbtest02","postgres", "postgres");
			//"jdbc:postgresql://hostname:port/dbname","username", "password"
			
			//statement�����㣬�������׷���ע��Σ��
			Statement stmt = connection.createStatement();
			String sql = "insert into users01 (username, pwd, regTime, id) values ('��Ҳ',555,now(),10)";
			stmt.execute(sql);
			
			//����SQLע��
//			String id = "5";
//			String id = "5 or 1=1";��Զtrue����ɾ������
//			String sql = "delete from users01 whre id ="+id;
			
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
