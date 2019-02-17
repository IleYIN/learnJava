package testGeneric;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 泛型嵌套-->由外到内拆分
 * 
 * @author yinyiliang
 *
 */
public class QiantaoStudentGen {
	
	
	public static void main(String[] args) {
		StudentGen<String,String> stu = new StudentGen<String,String>();
		stu.setJavaScore("优秀");
		System.out.println(stu.getJavaScore());
		
		Banji<StudentGen<String,String>> banji = new Banji<StudentGen<String,String>>();
		banji.setStu(stu);//把学生放入班级
		
		StudentGen<String,String> stu2 = banji.getStu();
//		System.out.println(stu==stu2);
		
		String javaScore = stu2.getJavaScore();
		System.out.println(javaScore);
		
		//HashMap
		Map<String,String> map = new HashMap<String,String>();
		map.put("a", "java300");
		map.put("b", "马士兵javase");
		
		Set<Entry<String,String>> entrySet = map.entrySet();
		//把map放入entrySet
		
		for(Entry<String,String> entry : entrySet){
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"-->"+value);
		}
	}
}
