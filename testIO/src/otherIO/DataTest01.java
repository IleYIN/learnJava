package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �������ͣ�����+String��������
 * 
 * java.io.EOFException�쳣�� ��ʾ�Ѵﵽĩβ û�ж�ȡ����ص�����
 * ˳��һ��Ҳ�������
 * 
 * @author yinyiliang
 *
 */
public class DataTest01 {

	public static void main(String[] args) {
		
		try {
//			write("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
//			read("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
			read("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ļ���ȡ����+����
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException{
		
		//����Դ
		File src = new File(destPath);
		//ѡ����
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				); 
		
		//������ȡ��˳����д����һ�� ������ڲ��ܶ�ȡ
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		
		dis.close();//�ɲ���
		System.out.println(num1+"	"+num2+"	"+str);
	}
	
	
	
	/**
	 * ����+����������ļ�(����Ķ����ǻ����ܶ����˲��ܶ���)
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException{
		
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		
		//����Դ
		File dest = new File(destPath);
		
		//ѡ����
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
 	
		//���� д����˳�� Ϊ��ȡ��׼�� ����һ��
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		
		//�ͷ�
		dos.close();
	}
}
