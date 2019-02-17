package testCollections.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * 使用类相对路径读取配置文件
 * bin (Window --> show view--> navigator)
 * 
 * 两种方式到bin目录(类所在根路径)
 * 1. 类 class.getResourceAsStream("/")
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
		
//		//类相对路径; "/"表示根目录bin目录
//		pro.load(Test04.class.getResourceAsStream("/testCollections/properties/db.properties"));
//		System.out.println(pro.getProperty("user","bjsxt"));
		
		//类加载器 当前的类线程; ""表示bin目录
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("testCollections/properties/db.properties"));;
		System.out.println(pro.getProperty("user","bjsxt"));
		
		
	}
}
