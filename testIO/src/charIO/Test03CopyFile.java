package charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

/**
 * ֻ�ܿ����ַ����ı�
 * 
 * @author yinyiliang
 *
 */
public class Test03CopyFile {

	public static void main(String[] args) {
		
		File src = new File("D:/informatique/MyEclipse workspace/testIO/src/charIO/test.txt");
		File dest = new File("D:/informatique/MyEclipse workspace/testIO/src/charIO/char.txt");
		
		Reader reader = null;
		Writer wr = null;

		try {
			reader = new FileReader(src);
			wr = new FileWriter(dest,true);//����true��ʾ׷�� ����ԭ���Ķ���

			//��ȡ����
			char[] flush = new char[1024];
			int len = 0;
			while(-1 != (len=reader.read(flush))){
				wr.write(flush,0,len);
			}
			wr.flush();//ǿ��ˢ��
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Դ�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ���ȡʧ��");
		} finally{//��򿪵��ȹر�
			try {
				if (null != wr) {
					wr.close();
				} 
			} catch (Exception e2) {
				System.out.println("��д�ļ��ر�ʧ��");
			}
			try {
				if (null != reader) {
					reader.close();//ѡ��if�ļ���Ȼ��alt+shift+Z
				} 
			} catch (Exception e2) {
				System.out.println("�����ļ��ر�ʧ��");
			}
		}
	}
}
