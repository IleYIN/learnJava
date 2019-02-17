package otherIO2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestClose {

	public static void main(String[] args){
	
//		String src = "D:/informatique/MyEclipse workspace/testIO/src/byteIO/earth.png";
//		String dest = "D:/informatique/MyEclipse workspace/testIO/src/byteIO/testcopy.png";
//		copyFile(src,dest);
		
		String src2 = "D:/informatique/MyEclipse workspace/testIO/src/byteIO/testwrite.txt";
		String dest2 = "D:/informatique/MyEclipse workspace/testIO/src/byteIO/testcopy2";
		try {
			copyFile(src2,dest2);
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("拷贝文件失败或者关闭流失败");
			e.printStackTrace();
		}
	}
	
	

	/**
	 * JDK1.7的新特性
	 * try(){} -- with  --resource
	 */	
	public static void copyFile2(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//建立联系 源（存在且为文件） + 目的地（文件可以不存在）
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		if(! src.isFile() && src.exists()){//不是文件
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
			//有throw了就不用return了
		}
		
		
		try(
				//选择流
				InputStream is = new FileInputStream(srcPath);
				OutputStream os = new FileOutputStream(destPath,true);
		){
			//文件拷贝 循环+读取+写出
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len=is.read(flush))){
				os.write(flush,0,len);//用len的好处是有多少就写多少  避免没有了还在写
			}
			os.flush();//强制刷出
//		}catch(){
//			
		}
		//关闭流 后打开的先关闭
		
	}
	
	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//建立联系 源（存在且为文件） + 目的地（文件可以不存在）
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		if(! src.isFile() && src.exists()){//不是文件
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
			//有throw了就不用return了
		}
		
		
		//选择流
		InputStream is = new FileInputStream(srcPath);
		OutputStream os = new FileOutputStream(destPath,true);
		
		//文件拷贝 循环+读取+写出
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){
			os.write(flush,0,len);//用len的好处是有多少就写多少  避免没有了还在写
		}
		os.flush();//强制刷出
		
		//关闭流 后打开的先关闭

//		FileUtil.close(os,is);
		FileCloseUtil.close2(os,is);
		
	}
	
	
}

