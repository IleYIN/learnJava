package testGeneric;

/**
 * 泛型的擦除
 * 继承或实现声明不指定类型
 * 使用时不指定类型
 * 统一Object对待（会有编译器的警告提示）但不等于Object，擦除不会编译类型检查
 * @author yinyiliang
 *
 * @param <T>
 */
public class StudentGen2<T> {
	private T javaScore;
	private T oracleScore;

//	private static T3 a; 错误的
	
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
		StudentGen2 stu = new StudentGen2();//擦除
		//消除警告使用Object 指定具体类型
		StudentGen2<Object> stu1 = new StudentGen2<Object>();
		
		
		stu.setJavaScore("aaa");//以Object对待
		
//		test(stu1); 此行报错，因为指定了具体类型
		test(stu);//而擦除不报错因为擦除不会类型检查
		test1(stu1);
		test1(stu);
	}
}
