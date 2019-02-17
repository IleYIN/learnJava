package testException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFileTryCatch {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("pw.txt");//���ⲿ�ļ��й�����Ҫ��try catch���������
			char c = (char)reader.read();//�׳�IOException
			char c2 = (char)reader.read();//�׳�IOException
			System.out.println(c+c2);//����ļӺű������ַ������
			System.out.println(""+c+c2);//�ַ�����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {//FileNotFoundException��IOException�����࣬�����ǰ�棬����ź��棬��Ȼ�����޷�������
			e.printStackTrace();
		}finally{  //ע�ⲻҪ��finally���return�����Ḳ��֮ǰtry��catch���return���
			try {
				if (reader != null) //����reader�ǿ�
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//�׳��쳣
		}
		
	}
}
