package testCollections.properties;

import java.util.Properties;

/**
 * Properties 
 * Hashtable������
 * ��Դ�����ļ��Ķ�д
 * key��valueֻ�����ַ���
 * 
 * @author yinyiliang
 *
 */
public class Test01 {

	public static void main(String[] args) {
		//��������
		Properties pro = new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
//		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//��ȡ
		String url = pro.getProperty("url", "test");
		//getProperty(key,defaultValue)��key�����ھͷ���Ĭ��ֵ
		System.out.println(url);
	}
}
