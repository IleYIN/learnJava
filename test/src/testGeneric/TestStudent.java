package testGeneric;

/**
 * ��ȡֵ��ǿ������ת��
 * �ֶ����ͼ�����ת��������
 * ���� �����������Զ����
 * @author yinyiliang
 *
 */

public class TestStudent {
	
	public static void main(String[] args) {
		Object obj = 80;
		int score = (int)obj;//jdk1.7�Ժ�Object-->Integer-->�Զ�����
		
		//�������� int�Զ�װ��-->Integer-->Object
		Student stu = new Student(80,90);
		int javaseScore = (Integer)stu.getJavase();
		
		String oracleScore = null;
		if (stu.getOracle() instanceof String){
			oracleScore = (String)stu.getOracle();
		}
		System.out.println(javaseScore + " "+ oracleScore);
	}
}
