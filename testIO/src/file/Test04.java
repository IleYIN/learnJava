package file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * ����Ŀ¼
 * mkdir() ����Ŀ¼������ȷ����Ŀ¼���ڣ���������ڣ�����ʧ��
 * mkdirs() ����Ŀ¼�������Ŀ¼����������һͬ����
 * 
 * String[] list()����ĳ��Ŀ¼�������ļ���Ŀ¼���ļ���
 * String[] list(FilenameFilter filter)
 * 
 * File[] listFiles() ����ĳ��Ŀ¼�������ļ���Ŀ¼�ľ���·��
 * File[] listFiles(FileFileter fileter)
 * 
 * @author yinyiliang
 *
 */
public class Test04 {

	public static void main(String[] args) {
	
		System.out.println("-----��Ŀ¼�ļ���-----");
		String path = "D:/informatique/MyEclipse workspace/testIO/src/file";
		File src = new File(path);//�ļ���
		if(src.isDirectory()){
			String[] subNames = src.list();//����Ŀ¼��
			for(String temp:subNames){
				System.out.println(temp);
			}
		}
		

		System.out.println("-----��Ŀ¼�ļ�File����-----");
		File[] subFiles = src.listFiles();
		for(File temp:subFiles){
			System.out.println(temp.getAbsolutePath());
		}
		
		
		/**
		 * �������ģʽ
		 */
		System.out.println("-----���ļ�.java����-----");
		//�ӿڲ���ֱ��new ֻ�ܴ�����������
		subFiles = src.listFiles(new FilenameFilter(){

			@Override
			//dir����src
			public boolean accept(File dir, String name) {
//				 System.out.println(dir.getName());
//				 System.out.println(dir.getAbsolutePath());
				return new File(dir,name).isFile() && name.endsWith(".java");//�ҳ��������ļ�����".java"��β
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
