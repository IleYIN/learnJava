package testCollections.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties��ȡ�����ļ�
 * ��Դ�����ļ�
 * load
 * loadFromXML
 * 
 * @author yinyiliang
 *
 */

public class Test03 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//��ȡ����·��
		pro.load(new FileReader("D:/informatique/MyEclipse workspace/test/src/testCollections/properties/db.properties"));
		System.out.println(pro.getProperty("user","aaa"));//getProperty(key,defaultValue)�������ڷ���Ĭ��ֵ
		
		//��ȡ���·��
		pro.load(new FileReader("src/testCollections/properties/db.xml"));
		//�Ҽ����Ի���Alt+Enter�鿴����
		System.out.println(pro.getProperty("user","bjsxt"));//getProperty(key,defaultValue)�������ڷ���Ĭ��ֵ
		
	}
}
