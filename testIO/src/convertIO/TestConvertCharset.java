package convertIO;

import java.io.UnsupportedEncodingException;

public class TestConvertCharset {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//����byte-->char
		String str = "�й�";//Ĭ��gdk�ַ���(ANSI)
		
		//����char-->byte
		byte[] data = str.getBytes();//Ĭ��gdk�ַ���
		//����byte-->char
		System.out.println(new String(data));//Ĭ��gdk�ַ���
		//�����������ַ�����ͬ
		
		//����char-->byte
		data = str.getBytes();//Ĭ��gdk�ַ���
		//����byte-->char
		System.out.println(new String(data,0,3));//Ĭ��gdk�ַ���,�ֽ���������
		
		//����char-->byte
		data = str.getBytes("utf-8");//�趨utf-8�����ַ���
		//����byte-->char
		System.out.println(new String(data));//Ĭ��gdk�ַ���
		//����������ַ�����ͳһ��������
		
		//����char-->byte
		byte[] data2 = str.getBytes("utf-8");
		//����byte-->char
		str = new String(data2,"utf-8");
		System.out.println(str);
		//�����������ַ�����ͬ
	}
}
