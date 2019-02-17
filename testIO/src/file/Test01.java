package file;

import java.io.File;

/**
 * 两个常量
 * 路径分隔符 ;
 * 名称分隔符  Windows \    其他 /
 * 
 * @author yinyiliang
 *
 */
public class Test01 {

	public static void main(String[] args) {
		
		System.out.println(File.pathSeparator);//;路径分隔符
		System.out.println(File.separator);// \
		
		//路径的几种表现形式
		String path = "D:\\informatique\\MyEclipse workspace\\test\\pw.txt";//转义
		
		path = "D:"+File.separator+"informatique"+File.separator+"MyEclipse workspace"+File.separator+"test"+File.separator+"pw.txt";
		//适合动态生成
		
		path = "D:/informatique/MyEclipse workspace/test/pw.txt";
		//推荐这种方式
	}
}
