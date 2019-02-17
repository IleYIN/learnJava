package file;

import java.io.File;
import java.io.IOException;

/**
 * File常用方法
 * 
 * @author yinyiliang
 *
 */
public class Test03 {

	public static void main(String[] args){
//		test1();
		test2();
//		try {
//			test3();
//		} catch (IOException e) {
//			System.out.println("文件操作失败");
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 构建信息
	 */
	
	public static void test1(){
	
//		File src = new File("2.jpg");
		File src = new File("D:/informatique/MyEclipse workspace/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());//如果是绝对路径返回绝对路径，否则返回相对路径
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());//返回上一级目录，如果是相对，返回null
	}
	
	
	/**
	 * 判断属性信息
	 */
	public static void test2(){
//		String path = "2.txt";//false
		String path = "D:/informatique/MyEclipse workspace/testIO/1.txt";
//		String path = "D:/informatique/MyEclipse workspace/test";
		
		File src = new File(path);
		System.out.println("文件是否存在"+src.exists());
		//是否可读写
		System.out.println("是否可读写"+src.canRead()+src.canWrite());
		
		System.out.println("是文件还是文件夹"+src.isFile()+src.isDirectory());
		//无法判断后缀是否为文件名
		
		if(src.isFile()){
			System.out.println("文件");
		}else if(src.isDirectory()){
			System.out.println("文件夹");
		}else{
			System.out.println("文件不存在");
		}
		
		System.out.println(src.isAbsolute());//是否为绝对路径
		System.out.println(src.length());//只能读取文件的字节数 文件夹的不行
		
	}

	/**
	 * 创建删除文件
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void test3() throws IOException, InterruptedException{
		
		String path = "D:/informatique/MyEclipse workspace/testIO/1.jpg";
		File src = new File(path);//建立联系
////		if(!src.exists()){
//			boolean flag = src.createNewFile();//存在返回false
//			System.out.println(flag?"成功":"失败");
////		}
			
		boolean flag = src.delete();
		System.out.println(flag?"成功":"失败");
		
//		static createTempFile(前缀3个字节长,后缀默认.temp) 默认临时空间
//		static createTempFile(前缀3个字节长,后缀默认.temp,目录)
		File temp = File.createTempFile("tes", ".temp", new File("D:/informatique/MyEclipse workspace/testIO"));
		
		Thread.sleep(5000);
		temp.deleteOnExit();//退出即删除
	}
}
