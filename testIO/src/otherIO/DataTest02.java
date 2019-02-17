package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * �������ͣ�����+String��������
 * 
 * ����+����������ֽ�������
 * 
 * java.io.EOFException�쳣�� ��ʾ�Ѵﵽĩβ û�ж�ȡ����ص�����
 * ˳��һ��Ҳ�������
 * 
 * @author yinyiliang
 *
 */
public class DataTest02 {

	public static void main(String[] args) {
		
		try {
//			write("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
//			read("D:/informatique/MyEclipse workspace/testIO/parent/1.txt");
//			read("D:/informatique/MyEclipse workspace/testIO/parent/data.txt");
			
			byte[] data = write();
			System.out.println(data.length);
			read(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ֽ������ȡ����+����
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException{
		
		//ѡ����
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				); 
		
		//������ȡ��˳����д����һ�� ������ڲ��ܶ�ȡ
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		
		dis.close();
		
		System.out.println(num1+"	"+num2+"	"+str);
	}
	
	
	
	/**
	 * ����+����������ֽ�������(����Ķ����ǻ����ܶ����˲��ܶ���)
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException{
		
		//Ŀ������
		byte[] dest = null;
		
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		
		//ѡ����
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						bos
						)
				);
 	
		//���� д����˳�� Ϊ��ȡ��׼�� ����һ��
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		
		dest = bos.toByteArray();
		
		//�ͷ�
		dos.close();
		
		bos.close();//�ɼӿɲ���
		
		return dest;
	}
}
