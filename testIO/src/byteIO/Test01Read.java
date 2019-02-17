package byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��Ķ�ȡ
 * ע���ļ����ǲ���������ȡ��
 * 
 * 
 * @author yiny
 *
 */
public class Test01Read {

	public static void main(String[] args) {
		
		//������ϵ File����
		File src = new File("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
		
		//ѡ����
		InputStream is = null;//����������
		try {
			is = new FileInputStream(src);
//			InputStream is = new FileInputStream("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
			
			//�������϶�ȡ ��������
			byte[] car = new byte[10];
			int len = 0; //���� ʵ�ʶ�ȡ��С
			
			//ѭ����ȡ���������û����ins.read(car)��ȡֵΪ-1    
			while(-1 != (len = is.read(car))){
				//��� �ֽ�����ת���ַ���
				String info = new String(car,0,len);
				System.out.println(info);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��ȡ�ļ�ʧ��");
			e.printStackTrace();
		}finally{ //�ͷ���Դ
			
				try {
					if (null != is){//���ļ������ڵ������   is�п�����null
						is.close();
					}
				} catch (Exception e2) {//ѡ��if�Ǽ���  ��alt+shift+z-->try catch block
					System.out.println("�ر��ļ�������ʧ��");
				}
			
		}
	}
}
