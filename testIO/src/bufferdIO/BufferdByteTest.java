package bufferdIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流文件拷贝+缓冲流提高性能
 * 缓冲流（字节流）
 * 
 * @author yinyiliang
 *
 */
public class BufferdByteTest {

	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//建立联系 源（存在且为文件） + 目的地（文件可以不存在）
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		if(! src.isFile() && src.exists()){//不是文件
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
			//有throw了就不用return了
		}
		
		
		/**
		 * 增加缓冲流提高性能
		 */
		
		//选择流
		InputStream is = new BufferedInputStream(new FileInputStream(srcPath));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		
		//文件拷贝 循环+读取+写出
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){
			os.write(flush,0,len);//用len的好处是有多少就写多少  避免没有了还在写
		}
		os.flush();//强制刷出
		
		//关闭流 后打开的先关闭
		os.close();
		is.close();//不用加判断非空 因为不能是null
		
	}
	
}
