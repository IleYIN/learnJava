package annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo01  {

	@Override//��ʾ�̳и��෽��
	public String toString() {
		return super.toString();
	}
	
	@Deprecated//�������� ������ʹ��
	public static void test1() {
		
	}
	
	@SuppressWarnings("all")//ѹ�ƾ���
	//@SuppressWarnings(value = "unchecked","deprecation")
	public static void test2() {
		List list = new ArrayList();
		List list2 = new ArrayList();
		
	}
	
	public static void main(String[] args) {
		test1();
	}
}
