package testGeneric;

public class QianTao<T> {
	T stu;
	
	public static void main(String[] args) {
		//���͵�Ƕ�� Ҫ���⵽�ڲ��
		QianTao<StudentWenhao<String>> room = new QianTao<StudentWenhao<String>>();
		room.stu = new StudentWenhao<String>();
		StudentWenhao<String> stu = room.stu;
		String score = stu.score;
		System.out.println(score);
	} 
}
