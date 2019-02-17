package charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;

/**
 * д���ļ�
 * write(String,0,length)+flush
 * write(String)
 * append(char|String) 
 * @author yinyiliang
 *
 */
public class Test02Write {

	public static void main(String[] args) {

		File dest = new File("D:/informatique/MyEclipse workspace/testIO/src/charIO/char.txt");

		Writer wr = null;
		try {
			wr = new FileWriter(dest,true);//����true��ʾ׷�� ����ԭ���Ķ���
			String msg = "�����յ���\r\n��ũ������\r\n";
			wr.write(msg);
			wr.append("��������\r\n");
			
			wr.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if (null != wr) {
					wr.close();
				} 
			} catch (Exception e2) {
				System.out.println("�ļ��ر�ʧ��");
			}
		}
	}
}
