package testGeneric;

/**
 * ������ʹ�÷�����ĸ
 * T Type
 * K V Key Value
 * E Element
 * ʹ��ʱָ������
 * ע�⣺����ֻ��ʹ���������Ͳ��ܻ�������
 *     ������ĸ����ʱ����ʹ�þ�̬���Ի�̬�����ϣ���Ϊ����ʹ��ʱȷ���ģ�����̬�Ǳ���ʱȷ����
 * 
 * @author yinyiliang
 *
 */
public class StudentGen<T1, T2> {
	private T1 javaScore;
	private T2 oracleScore;

//	private static T3 a; ����ģ�������ĸ����ʱ����ʹ�þ�̬���Ի�̬����
	
	public T1 getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}
	public T2 getOracleScore() {
		return oracleScore;
	}
	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}

	
	public static void main(String[] args) {
		//ʹ��ʱָ������(��������)
		StudentGen<String,Integer> stu = new StudentGen<String, Integer>();
		//�Զ����ͼ��
		stu.setJavaScore("����");
		//�Զ�����ת���Ͳ���
		int it = stu.getOracleScore();
	}
	
}

class Banji<T>{
	private T stu;

	public T getStu() {
		return stu;
	}

	public void setStu(T stu) {
		this.stu = stu;
	}
	
}