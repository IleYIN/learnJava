package test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class testPrintWriter {
	public static void main(String[] args) { 
 //打开文件 FileOutputStream fos=new FileOutputStream("pw.txt"); //设置编码集 OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8"); /** * 创建具有自动刷新的PrinterWriter后，每当我们使用println()/print() * 方法写出字符串后，都会自动调用flush()方法 * 但是,这个无疑会增加写出次数而降低写出效率 */ //写出数据 PrintWriter pw=new PrintWriter(osw, true); pw.println("字符缓冲"); pw.append("测试数据"); pw.write("哈哈哈"); pw.close(); } catch (Exception e) { e.printStackTrace(); } } 
		try{
			FileOutputStream fos = new FileOutputStream("pw.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			/** * 创建具有自动刷新的PrinterWriter后，每当我们使用println()/print() * 方法写出字符串后，都会自动调用flush()方法 * 但是,这个无疑会增加写出次数而降低写出效率 */ 
			//写出数据 
			
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
