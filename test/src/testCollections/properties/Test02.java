package testCollections.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties输出到文件
 * 资源配置文件：动态切换数据库 不需要改代码
 * 
 * store()--> .properties
 * storeToXML()--> .xml
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test02 {
												//FileNotFound检查时异常与外界联系
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//存储到e:/others 绝对路径的 带盘符:
		pro.store(new FileOutputStream(new File("D:/informatique/MyEclipse workspace/test/src/testCollections/properties/db.properties")), "db配置");
		pro.storeToXML(new FileOutputStream(new File("D:/informatique/MyEclipse workspace/test/src/testCollections/properties/db.xml")), "db配置");
		
		//使用相对路径 相对当前的工程JavaProject 若放进src包里加上src/
//		pro.store(new FileOutputStream(new File("src/db.properties")), "db配置");
//		pro.storeToXML(new FileOutputStream(new File("src/db.xml")), "db配置");
//		pro.storeToXML(new FileOutputStream(new File("src/testCollections/properties/db.xml")), "db配置");
	}
}
