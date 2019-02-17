package testGeneric;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * ���ͷ��� <>�������η����棬�������͵�ǰ��
 * ���ͷ���ֻ�ܷ��ʶ������Ϣ�������޸���Ϣ��a.set����Ϊ���Ͳ���
 * @author yinyiliang
 *
 */

public class TestMethod {
	
	public static <T> void test(T a){
		System.out.println(a);
	}
	
	public static <T extends Closeable> void test(T... a){
		System.out.println(a); //Tֻ����Closeable�ӿڵ�ʵ����
		//T...��ʾ�ɱ������ʹ�÷���������һ��
		//Java�����ͺ�����������ʾ������ĸ����ǲ�ȷ���ģ����ݶ��ٸ��������ǿ��Ե�
		for(T temp:a){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static <T extends List> void test(T t){
		System.out.println(t); 
		t.add("aaa");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		test("�ַ���");
		test(new FileInputStream("a.txt"));
	}
	
}
