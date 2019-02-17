package byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	


	
	/**
	 * 文件拷贝
	 * @param src
	 * @param dest
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void copyFile(File src, File dest) throws FileNotFoundException,IOException {

		if(! src.isFile() && src.exists()){//不是文件
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
			//有throw了就不用return了
		}
		
		//如果dest为文件夹，则无法访问，所以改成在该文件夹里的新文件路径
		if(dest.isDirectory()){
			dest = new File(dest,src.getName());
		}
		
		//选择流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest,true));
		
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
	
	/**
	 * 文件拷贝
	 * 重载 File对象 --> String path
	 * @param srcPath
	 * @param destPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//建立联系 源（存在且为文件） + 目的地（文件可以不存在）
		
		copyFile(new File(srcPath),new File(destPath));
	}
	
	
	
	/**
	 * 拷贝文件夹路径
	 * 
	 * @param srcPath
	 * @param destPath
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(String srcPath, String destPath) throws FileNotFoundException, IOException{

		File src = new File(srcPath);
		File dest = new File(destPath);
		
		//调用
			copyDir(src, dest);
	}
	
	
	
	
	/**
	 * 拷贝文件夹建立目标文件夹的路径对象，然后调用拷贝文件夹内容
	 *
	 * @param src
	 * @param dest
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(File src, File dest) throws FileNotFoundException, IOException {
		if(src.isDirectory()){//如果是文件夹则创建文件夹
			dest = new File(dest, src.getName());//File(String parent, String child) 在父目录里创建和child名字一样的对象
			//这里就是在destPath路径下创建了和src名字一样的对象（文件夹1）并赋给dest，注意此时还没有创建文件夹，只是创建了路径对象，后面dest.mkdirs()才是创建了文件夹
		
			//避免超长文件夹和父目录拷贝到子目录的情况
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				System.out.println("父目录不能拷贝到子目录中");
				return;
			}
			
		}
	
		copyDirContent(src, dest);//把源文件夹1里的东西拷贝到目标文件夹1里
	
	}
	
	
	
	/**
	 * 拷贝文件夹里的内容
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException 
	 */
	public static void copyDirContent(File src, File dest) throws FileNotFoundException, IOException{
		if(src.isFile()){//源文件是文件就直接copy
			try {
//				System.out.println(dest.getAbsolutePath());
				
				FileUtil.copyFile(src, dest);
				
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				throw e;
			} catch (IOException e) {
				//e.printStackTrace();
				throw e;
			}
		}else if(src.isDirectory()){//源文件是文件夹
			
			//确保目标文件夹和目标文件的路径存在
			dest.mkdirs();//以dest的路径建立文件夹（用于以后往里存放文件）
//			System.out.println(dest.getAbsolutePath());
			
			//获取下一级目录|文件；
			for (File sub:src.listFiles()){//源文件夹1里的东西拷贝到目标文件夹1的路径下
			
//				System.out.println(sub.getAbsolutePath());
				
				copyDirContent(sub, new File(dest,sub.getName()));//这里递归，调用自身，此时新的dest位置上是File(dest,sub.getName()
			}
		}else throw new FileNotFoundException("文件不存在");

	}


}
