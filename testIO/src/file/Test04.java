package file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 操作目录
 * mkdir() 创建目录，必须确保父目录存在，如果不存在，创建失败
 * mkdirs() 创建目录，如果父目录链不存在则一同创建
 * 
 * String[] list()返回某个目录下所有文件和目录的文件名
 * String[] list(FilenameFilter filter)
 * 
 * File[] listFiles() 返回某个目录下所有文件和目录的绝对路径
 * File[] listFiles(FileFileter fileter)
 * 
 * @author yinyiliang
 *
 */
public class Test04 {

	public static void main(String[] args) {
	
		System.out.println("-----子目录文件名-----");
		String path = "D:/informatique/MyEclipse workspace/testIO/src/file";
		File src = new File(path);//文件夹
		if(src.isDirectory()){
			String[] subNames = src.list();//返回目录名
			for(String temp:subNames){
				System.out.println(temp);
			}
		}
		

		System.out.println("-----子目录文件File对象-----");
		File[] subFiles = src.listFiles();
		for(File temp:subFiles){
			System.out.println(temp.getAbsolutePath());
		}
		
		
		/**
		 * 命令设计模式
		 */
		System.out.println("-----子文件.java对象-----");
		//接口不能直接new 只能创建匿名对象
		subFiles = src.listFiles(new FilenameFilter(){

			@Override
			//dir代表src
			public boolean accept(File dir, String name) {
//				 System.out.println(dir.getName());
//				 System.out.println(dir.getAbsolutePath());
				return new File(dir,name).isFile() && name.endsWith(".java");//找出必须是文件且以".java"结尾
			}
			
		});
		
		for(File temp:subFiles){
			System.out.println(temp.getAbsolutePath());
		}
	}
	
	public static void test1(){
		String path = "D:/informatique/MyEclipse workspace/testIO/parent/test";
		File src = new File(path);
//		src.mkdir();
		src.mkdirs();
	}
}
