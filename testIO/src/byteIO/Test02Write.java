package byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * д���ļ�
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test02Write {

	public static void main(String[] args) {
		
		//������ϵ
		File dest = new File("D:/informatique/MyEclipse workspace/testIO/src/byteIO/testwrite.txt");
		
		//ѡ���� �ļ������ OutputStream FileOutputStream
		OutputStream os = null;
		
		try {
			//��׷�ӵ���ʽд�� ����true �������Ǹ���
			os = new FileOutputStream(dest,true);
			
			//����
			String str = "He's very good \r\n";
			//�ַ���ת�ֽ�����
			byte[] data = str.getBytes();
			os.write(data,0,data.length);
			//ǿ��ˢ�³�ȥ ��ֹ������
			os.flush();
			
//		} catch (FileNotFoundException e) {
//			System.out.println("�ļ�δ�ҵ�");
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�ļ�д��ʧ��");
			e.printStackTrace();
		}finally{
			try {
//				if (null != os) {//���ļ������ڵ������   ������null
					os.close();//�ر���Դ
//				} 
			} catch (Exception e2) {
				System.out.println("�ر������ʧ��");
			}
		}
	}
}
