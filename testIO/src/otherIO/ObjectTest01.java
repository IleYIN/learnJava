package otherIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;


/**
 * 
 * �������ж�������Զ��������л�
 * ���û��implements java.io.Serializable �ᱨ�쳣 java.io.NotSerializableException
 * 
 * @author yinyiliang
 *
 */
public class ObjectTest01 {

	public static void main(String[] args) {
		
		try {
			seri("D:/informatique/MyEclipse workspace/testIO/parent/object.txt");
			read("D:/informatique/MyEclipse workspace/testIO/parent/object.txt");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//�����л�
	public static void read(String srcPath) throws IOException, ClassNotFoundException{
		
		//����Դ
		File src = new File(srcPath);

		//ѡ����
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);

		//���� ��ȡ��˳����д��һ�� ������ڲ��ܶ�ȡ
		//��һ�������ݴ�������
		Object obj = ois.readObject();
		if(obj instanceof Employee){
			
			Employee emp = (Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
			
		}
		
		obj = ois.readObject();
		int[] arr = (int[])obj;
		System.out.println(Arrays.toString(arr));
		//�ͷ�
		ois.close();
	}
	
	
	//���л�
	public static void seri(String destPath) throws FileNotFoundException, IOException{
		
		Employee emp = new Employee("lalala",1000000);
		
		int[] arr = {1,3,4,5};
		
		//����Դ
		File dest = new File(destPath);

		//ѡ����
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);

		//���� д����˳�� Ϊ��ȡ��׼�� ����һ��
		dos.writeObject(emp);
		dos.writeObject(arr);
		
		dos.flush();

		//�ͷ�
		dos.close();
	}
	
}
