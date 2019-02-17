package testGeneric;

/**
 * 声明是使用泛型字母
 * T Type
 * K V Key Value
 * E Element
 * 使用时指定类型
 * 注意：泛型只能使用引用类型不能基本类型
 *     泛型字母声明时不能使用静态属性或静态方法上，因为是在使用时确定的，而静态是编译时确定的
 * 
 * @author yinyiliang
 *
 */
public class StudentGen<T1, T2> {
	private T1 javaScore;
	private T2 oracleScore;

//	private static T3 a; 错误的，范型字母声明时不能使用静态属性或静态方法
	
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
		//使用时指定类型(引用类型)
		StudentGen<String,Integer> stu = new StudentGen<String, Integer>();
		//自动类型检查
		stu.setJavaScore("优秀");
		//自动类型转换和拆箱
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