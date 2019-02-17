package testGeneric;

/**
 * 获取值：强制类型转换
 * 手动类型检查避免转换有问题
 * 泛型 参数化类型自动检查
 * @author yinyiliang
 *
 */

public class TestStudent {
	
	public static void main(String[] args) {
		Object obj = 80;
		int score = (int)obj;//jdk1.7以后Object-->Integer-->自动拆箱
		
		//存入整数 int自动装箱-->Integer-->Object
		Student stu = new Student(80,90);
		int javaseScore = (Integer)stu.getJavase();
		
		String oracleScore = null;
		if (stu.getOracle() instanceof String){
			oracleScore = (String)stu.getOracle();
		}
		System.out.println(javaseScore + " "+ oracleScore);
	}
}
