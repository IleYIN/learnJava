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
			System.out.println("�ļ�������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�����ļ�ʧ�ܻ��߹ر���ʧ��");
			e.printStackTrace();
		}
	}
	
	

	/**
	 * JDK1.7��������
	 * try(){} -- with  --resource
	 */	
	public static void copyFile2(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//������ϵ Դ��������Ϊ�ļ��� + Ŀ�ĵأ��ļ����Բ����ڣ�
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		if(! src.isFile() && src.exists()){//�����ļ�
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
			//��throw�˾Ͳ���return��
		}
		
		
		try(
				//ѡ����
				InputStream is = new FileInputStream(srcPath);
				OutputStream os = new FileOutputStream(destPath,true);
		){
			//�ļ����� ѭ��+��ȡ+д��
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len=is.read(flush))){
				os.write(flush,0,len);//��len�ĺô����ж��پ�д����  ����û���˻���д
			}
			os.flush();//ǿ��ˢ��
//		}catch(){
//			
		}
		//�ر��� ��򿪵��ȹر�
		
	}
	
	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//������ϵ Դ��������Ϊ�ļ��� + Ŀ�ĵأ��ļ����Բ����ڣ�
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		if(! src.isFile() && src.exists()){//�����ļ�
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
			//��throw�˾Ͳ���return��
		}
		
		
		//ѡ����
		InputStream is = new FileInputStream(srcPath);
		OutputStream os = new FileOutputStream(destPath,true);
		
		//�ļ����� ѭ��+��ȡ+д��
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){
			os.write(flush,0,len);//��len�ĺô����ж��پ�д����  ����û���˻���д
		}
		os.flush();//ǿ��ˢ��
		
		//�ر��� ��򿪵��ȹر�

//		FileUtil.close(os,is);
		FileCloseUtil.close2(os,is);
		
	}
	
	
}

