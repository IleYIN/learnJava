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
 * �ֽ����ļ�����+�������������
 * ���������ֽ�����
 * 
 * @author yinyiliang
 *
 */
public class BufferdByteTest {

	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//������ϵ Դ��������Ϊ�ļ��� + Ŀ�ĵأ��ļ����Բ����ڣ�
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		if(! src.isFile() && src.exists()){//�����ļ�
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
			//��throw�˾Ͳ���return��
		}
		
		
		/**
		 * ���ӻ������������
		 */
		
		//ѡ����
		InputStream is = new BufferedInputStream(new FileInputStream(srcPath));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		
		//�ļ����� ѭ��+��ȡ+д��
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){
			os.write(flush,0,len);//��len�ĺô����ж��پ�д����  ����û���˻���д
		}
		os.flush();//ǿ��ˢ��
		
		//�ر��� ��򿪵��ȹر�
		os.close();
		is.close();//���ü��жϷǿ� ��Ϊ������null
		
	}
	
}
