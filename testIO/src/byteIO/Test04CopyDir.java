package byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件夹拷贝
 * 文件 复制（IO流复制） copyFile
 * 文件夹创建mkdirs()
 * 递归查找子孙级文件|文件夹
 * 
 * 
 * 	   A
 *    / \
 *a.txt  b
 * 		 |
 * 		b.txt
 * 
 *    CopyAA
 * 		 |
 * 	     A
 * 		/ \
 *   a.txt b
 *   	   |
 *        b.txt
 *   
 *   不能父目录拷贝到子目录中
 *   避免超长文件夹问题robotcopy
 *   
 * @author yinyiliang
 *
 */

public class Test04CopyDir {

	public static void main(String[] args) {
		
		String srcPath = "D:/informatique/MyEclipse workspace/testIO/src/1";
		String destPath = "D:/informatique/MyEclipse workspace/testIO/src/1/2";
		
		try {
			FileUtil.copyDir(srcPath, destPath);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}