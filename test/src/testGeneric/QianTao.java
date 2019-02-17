package testGeneric;

public class QianTao<T> {
	T stu;
	
	public static void main(String[] args) {
		//泛型的嵌套 要从外到内拆分
		QianTao<StudentWenhao<String>> room = new QianTao<StudentWenhao<String>>();
		room.stu = new StudentWenhao<String>();
		StudentWenhao<String> stu = room.stu;
		String score = stu.score;
		System.out.println(score);
	} 
}
