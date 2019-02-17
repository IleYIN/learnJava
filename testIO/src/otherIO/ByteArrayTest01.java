package otherIO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ����� �ڵ���
 * ���鳤�����ޣ�����������ܴ�
 * 
 * �ļ����ݲ���
 * 1���ļ�����-->�ļ�������+�ֽ����������-->�ֽ�����
 * 2���ֽ�����-->�ֽ�����������+�ļ������-->�ļ�
 * 
 * 
 * @author yinyiliang
 *
 */
public class ByteArrayTest01 {

	
	public static void main(String[] args) throws IOException {
		read(write());
	}
	
	/**
	 * ������ �������ļ�����������һ��	
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException{
		
//		//����Դ
//		String msg = "lalalala";
//		byte[] src = msg.getBytes();
		
		//ѡ����
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src) //�����û����ϵ���ü��쳣
				);
		
		//����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){//�����׳��쳣����Ϊ�п��ܶ�ȡʧ��
			System.out.println(new String(flush,0,len));
		}
		
		//�ͷ���Դ
		is.close();
	}
	
	/**
	 * �����
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException{
		
		byte[] dest;
		
		//��ѡ������ͬ��
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//���� д��
		String msg = "����������";
		byte[] info = msg.getBytes();
		bos.write(info,0,info.length);
	
		//��ȡ����
		//��ѡ������ͬ��
		dest = bos.toByteArray();
		
		//�ͷ���Դ
		bos.close();
		
		return dest;
	}
}
