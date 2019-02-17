package convertIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * ת�������ֽ�תΪ�ַ�
 * �����OutputStreamWriter����
 * ������InputStreamWriter����
 * @author yinyiliang
 *
 */
public class TestConvertByteToChar {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("D:/informatique/MyEclipse workspace/testIO/parent/TestConvertCharSet.java")),
						//���ڶ�ȡԴ�ļ�ʱ����ָ���ַ����������ǵ��ļ��õ���UTF-8�ַ����� ����Ϊ�����ĵ�����������ֻ�ܵײ�ʹ���ֽ���
						"UTF-8"
						//���Զ�ȡʱ��Ҫת����InputStreamReader���ֽ�ת���ַ�,��ʱ�Ϳ�������ַ�����
						)
				);  
		//д���ļ�
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:/informatique/MyEclipse workspace/testIO/parent/Copy.java")
				);
		String info = null;
		while(null != (info=br.readLine())){
			bw.write(info+"\r\n");
			bw.flush();
			System.out.println(info);
		}
		bw.close();
		br.close();
	}
}
