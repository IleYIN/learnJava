package testGeneric;

/**
 * ���͵Ĳ���
 * �̳л�ʵ��������ָ������
 * ʹ��ʱ��ָ������
 * ͳһObject�Դ������б������ľ�����ʾ����������Object����������������ͼ��
 * @author yinyiliang
 *
 * @param <T>
 */
public class StudentGen2<T> {
	private T javaScore;
	private T oracleScore;

//	private static T3 a; �����
	
	public T getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(T javaScore) {
		this.javaScore = javaScore;
	}
	public T getOracleScore() {
		return oracleScore;
	}
	public void setOracleScore(T oracleScore) {
		this.oracleScore = oracleScore;
	}

	public static void test(StudentGen2<Integer> a){
		
	}
	public static void test1(StudentGen2<?> a){
		
	}
	
	
	public static void main(String[] args) {
		StudentGen2 stu = new StudentGen2();//����
		//��������ʹ��Object ָ����������
		StudentGen2<Object> stu1 = new StudentGen2<Object>();
		
		
		stu.setJavaScore("aaa");//��Object�Դ�
		
//		test(stu1); ���б�����Ϊָ���˾�������
		test(stu);//��������������Ϊ�����������ͼ��
		test1(stu1);
		test1(stu);
	}
}
