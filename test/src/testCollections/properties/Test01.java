package testCollections.properties;

import java.util.Properties;

/**
 * Properties 
 * Hashtable的子类
 * 资源配置文件的读写
 * key与value只能是字符串
 * 
 * @author yinyiliang
 *
 */
public class Test01 {

	public static void main(String[] args) {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
//		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//获取
		String url = pro.getProperty("url", "test");
		//getProperty(key,defaultValue)若key不存在就返回默认值
		System.out.println(url);
	}
}
