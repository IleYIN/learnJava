package testGeneric;

/**
 * ͨ��� �ʺ�
 * �ʺ�ֻ���������� �����޸�
 * �ʺŵ�ʹ�� ֻ�����������ͻ򷽷�ʱ�ã����ܶ��������������Ӧ��ʱ��
 * ��ʹ�ã�
 * ? extends: <= ���� 
 * ? super :  >= ���� 
 * 
 * 
 * 
 * @author yinyiliang
 *
 * @param <T>
 */
public class StudentWenhao<T>{
	T score;
	
	public static void test(StudentWenhao<?> stu) {
		
	}
	
	public static void test2(StudentWenhao<? extends Fruit> stu) {
		
	}
	
	public static void test3(StudentWenhao<Fruit> stu) {
		
	}
	
	public static void test4(StudentWenhao<? super Fruit> stu) {
		
	}
	
	public static void main(String[] args) {
		StudentWenhao<?> stu = new StudentWenhao<String>();
		test(new StudentWenhao<Integer>());
		test2(new StudentWenhao<Apple>());
//		test3(new StudentWenhao<Apple>());���󣬷���û�ж�̬
		test4(new StudentWenhao<Fruit>());
		test4(new StudentWenhao<Object>());
		
//		����Ķ����У���Ϊʹ��ʱҪȷ������
//		test4(new StudentWenhao<?>());
		stu = new StudentWenhao<Fruit>();
//		test4(stu);  
		
	}



}
