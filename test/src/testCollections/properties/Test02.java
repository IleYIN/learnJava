package testCollections.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties������ļ�
 * ��Դ�����ļ�����̬�л����ݿ� ����Ҫ�Ĵ���
 * 
 * store()--> .properties
 * storeToXML()--> .xml
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test02 {
												//FileNotFound���ʱ�쳣�������ϵ
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//��������
		Properties pro = new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//�洢��e:/others ����·���� ���̷�:
		pro.store(new FileOutputStream(new File("D:/informatique/MyEclipse workspace/test/src/testCollections/properties/db.properties")), "db����");
		pro.storeToXML(new FileOutputStream(new File("D:/informatique/MyEclipse workspace/test/src/testCollections/properties/db.xml")), "db����");
		
		//ʹ�����·�� ��Ե�ǰ�Ĺ���JavaProject ���Ž�src�������src/
//		pro.store(new FileOutputStream(new File("src/db.properties")), "db����");
//		pro.storeToXML(new FileOutputStream(new File("src/db.xml")), "db����");
//		pro.storeToXML(new FileOutputStream(new File("src/testCollections/properties/db.xml")), "db����");
	}
}
