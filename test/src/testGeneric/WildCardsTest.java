package testGeneric;

/**
 *  ?-->ͨ��������Ͳ�ȷ�������������������β���
 *  �������ڴ����������򷽷���ӿ���
 */


import java.util.ArrayList;
import java.util.List;

public class WildCardsTest {
	
	public static void test(List<?> list){
		
	}
	
//	public static <?> void test2(List<?> list){
//		�ʺŲ��������������ͷ���
//	}
	
	public static void main(String[] args) {
		//����
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		list = new ArrayList<Object>();
		test(list);
		
		//�������
		//list = new ArrayList<?>();
		
	}
	
	class Test<T>{
		
	}
	
//	class Test2<?>{
//	�ʺŲ��ܴ���������	
//	}
	

}
