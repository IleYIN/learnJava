package byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * �ļ��п���
 * �ļ� ���ƣ�IO�����ƣ� copyFile
 * �ļ��д���mkdirs()
 * �ݹ�������Ｖ�ļ�|�ļ���
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
 *   ���ܸ�Ŀ¼��������Ŀ¼��
 *   ���ⳬ���ļ�������robotcopy
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