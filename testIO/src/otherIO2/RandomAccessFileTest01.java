package otherIO2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �ļ��ķָ�˼·
 * 1��׼��
 * �ָ�Ŀ���size  n��
 * ÿһ��Ĵ�С blockSize
 * ÿһ�������
 * ����ܵĴ�С(n-1)*blockSize
 * 2���ָ�
 * �ڼ��� ÿ����� ʵ�ʴ�С
 * �ļ��ָ�
 * 
 * @author yinyiliang
 *
 */
public class RandomAccessFileTest01 {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile rnd = new RandomAccessFile(new File("D:/informatique/MyEclipse workspace/testIO/parent/1.txt"),"r");//ֻ��
		rnd.seek(5);//�ӵڼ����ֽڿ�ʼ��
		
		//���建���С
		byte[] flush = new byte[1024];
		//���ճ���
		int len = 0;
		
		while(-1!=(len=rnd.read(flush))){
			
			if(len>=20){
				System.out.println(new String(flush,0,20));
				break;
			} else {
				System.out.println(new String(flush,0,len));
			}
		}
		
		FileCloseUtil.close(rnd);
	}
}
