package file;

import java.io.File;
import java.util.Arrays;

/**
 * ������ＶĿ¼�ļ������ƣ�����·����
 * 
 * String[] list()����ĳ��Ŀ¼�������ļ���Ŀ¼���ļ���
 * String[] list(FilenameFilter filter)
 * 
 * File[] listFiles() ����ĳ��Ŀ¼�������ļ���Ŀ¼�ľ���·��
 * File[] listFiles(FileFileter fileter)
 * 
 * �ݹ�
 * 
 * static listRoots() ��·��
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
	 * ���·��
	 */
	public static void printPath(File src){
		if(null==src || !src.exists()){
			return;
		}
//		System.out.println(src.getName());
		System.out.println(src.getAbsolutePath());
		
		
		if(src.isDirectory()){//�ļ���
			for(File sub:src.listFiles())
				printPath(sub);
			
		}
		
	}
	
}
