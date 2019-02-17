package testCollections.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties读取配置文件
 * 资源配置文件
 * load
 * loadFromXML
 * 
 * @author yinyiliang
 *
 */

public class Test03 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//读取绝对路径
		pro.load(new FileReader("D:/informatique/MyEclipse workspace/test/src/testCollections/properties/db.properties"));
		System.out.println(pro.getProperty("user","aaa"));//getProperty(key,defaultValue)若不存在返回默认值
		
		//读取相对路径
		pro.load(new FileReader("src/testCollections/properties/db.xml"));
		//右键属性或者Alt+Enter查看属性
		System.out.println(pro.getProperty("user","bjsxt"));//getProperty(key,defaultValue)若不存在返回默认值
		
	}
}
