package file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级目录文件的名称（绝对路径）
 * 
 * String[] list()返回某个目录下所有文件和目录的文件名
 * String[] list(FilenameFilter filter)
 * 
 * File[] listFiles() 返回某个目录下所有文件和目录的绝对路径
 * File[] listFiles(FileFileter fileter)
 * 
 * 递归
 * 
 * static listRoots() 根路径
 * 
 * @author yinyiliang
 *
 */
public class Test05 {

	public static void main(String[] args) {
		
		String path = "D:/informatique/MyEclipse workspace/testIO/parent";
		File parent = new File(path);
//		printName(parent);
		
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		
//		for(File temp:roots){
//			printPath(temp);
//		}
	}
	
	/**
	 * 输出路径
	 */
	public static void printPath(File src){
		if(null==src || !src.exists()){
			return;
		}
//		System.out.println(src.getName());
		System.out.println(src.getAbsolutePath());
		
		
		if(src.isDirectory()){//文件夹
			for(File sub:src.listFiles())
				printPath(sub);
			
		}
		
	}
	
}
