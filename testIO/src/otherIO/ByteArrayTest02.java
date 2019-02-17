package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * �ļ����ݲ���
 * 1���ļ�����-->�ļ�������+�ֽ����������-->�ֽ�����
 * 2���ֽ�����-->�ֽ�����������+�ļ������-->�ļ�
 * 
 * ע�� �ֽ�����������������������ܶ�̬ �������Ĳ�һ��
 * 
 * @author yinyiliang
 *
 */
public class ByteArrayTest02 {

	
	public static void main(String[] args) throws IOException {
		
		byte[] data = getBytesFromFile("D:/informatique/MyEclipse workspace/testIO/src/earth.png");
//		System.out.println(new String(data));
		toFileFromByteArray(data, "D:/informatique/MyEclipse workspace/testIO/parent/earth.png");
	}
	
	
	/**
	 * 1���ļ�����-->�ļ�������+�ֽ����������-->�ֽ�����
	 * @throws FileNotFoundException 
	 */
	public static byte[] getBytesFromFile(String srcPath) throws FileNotFoundException, IOException {
		
		//�����ļ�Դ
		File src = new File(srcPath);
		
		//�����ֽ�����Ŀ�ĵ�
		byte[] dest = null;
		
		//ѡ����
		//�ļ�������
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		
		//�ֽ��������������ʹ�ö�̬
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//���� ���϶�ȡ�ļ� д�����ֽ���������
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush))){
	
			//д�����ֽ���������
			bos.write(flush,0,len);
		}
		bos.flush();
		
		//��ȡ����
		dest = bos.toByteArray();
		//�ر�
		bos.close();
		is.close();
		
		return dest;
	}

	
	/**
	 * 2���ֽ�����-->�ֽ�����������+�ļ������-->�ļ�
	 */
	public static void toFileFromByteArray(byte[] src, String destPath)throws IOException{
		
		//����Դ
		//Ŀ�ĵ�
		File dest = new File(destPath);
		
		//ѡ����
		//�ֽ�����������
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		
		//�ļ������
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		
		//���� ���϶�ȡ�ֽ����� ������ļ�
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){
			os.write(flush,0,len);
		}
		os.flush();
		
		//�ͷ���Դ
		os.close();
		is.close();
	}
}
