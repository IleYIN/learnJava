package test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class testPrintWriter {
	public static void main(String[] args) { 
 //���ļ� FileOutputStream fos=new FileOutputStream("pw.txt"); //���ñ��뼯 OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8"); /** * ���������Զ�ˢ�µ�PrinterWriter��ÿ������ʹ��println()/print() * ����д���ַ����󣬶����Զ�����flush()���� * ����,������ɻ�����д������������д��Ч�� */ //д������ PrintWriter pw=new PrintWriter(osw, true); pw.println("�ַ�����"); pw.append("��������"); pw.write("������"); pw.close(); } catch (Exception e) { e.printStackTrace(); } } 
		try{
			FileOutputStream fos = new FileOutputStream("pw.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			/** * ���������Զ�ˢ�µ�PrinterWriter��ÿ������ʹ��println()/print() * ����д���ַ����󣬶����Զ�����flush()���� * ����,������ɻ�����д������������д��Ч�� */ 
			//д������ 
			
			PrintWriter pw = new PrintWriter(osw, true);
			pw.println("aaaaa");
			pw.append("2b");
			pw.write("3ccc");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
