package file;

import java.io.File;

/**
 * 相对路径与绝对路径构造File对象
 * 
 * 相对路径 File(String parentPath, String name)     File(File parentPath, String name)
 * 
 * 绝对路径 File(String name) 
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test02 {

	public static void main(String[] args) {
		String parentPath = "D:/informatique/MyEclipse workspace/test";
		String name = "2.jpg";
		
		//相对路径 相对父路径
		File src = new File(parentPath, name);
		//或
		src = new File(new File(parentPath),name);//是File对象 便于底层操作
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//绝对路径
		src = new File("D:/informatique/MyEclipse workspace/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//没有盘符windows 以user.dir工作项目下构建
		src = new File("test01.txt");
//		src = new File(".");//.表示当前路径
		System.out.println(src.getName());
		System.out.println(src.getPath());//相对路径
		System.out.println(src.getAbsolutePath());
	}
	
}
