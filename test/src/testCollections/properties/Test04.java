package testCollections.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * ʹ�������·����ȡ�����ļ�
 * bin (Window --> show view--> navigator)
 * 
 * ���ַ�ʽ��binĿ¼(�����ڸ�·��)
 * 1. �� class.getResourceAsStream("/")
 * 2. Thread.currentThread().getContextClassLoader().getResourceAsStream("")
 * 
 * 
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test04 {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		
//		//�����·��; "/"��ʾ��Ŀ¼binĿ¼
//		pro.load(Test04.class.getResourceAsStream("/testCollections/properties/db.properties"));
//		System.out.println(pro.getProperty("user","bjsxt"));
		
		//������� ��ǰ�����߳�; ""��ʾbinĿ¼
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("testCollections/properties/db.properties"));;
		System.out.println(pro.getProperty("user","bjsxt"));
		
		
	}
}
