package testGeneric;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ����Ƕ��-->���⵽�ڲ��
 * 
 * @author yinyiliang
 *
 */
public class QiantaoStudentGen {
	
	
	public static void main(String[] args) {
		StudentGen<String,String> stu = new StudentGen<String,String>();
		stu.setJavaScore("����");
		System.out.println(stu.getJavaScore());
		
		Banji<StudentGen<String,String>> banji = new Banji<StudentGen<String,String>>();
		banji.setStu(stu);//��ѧ������༶
		
		StudentGen<String,String> stu2 = banji.getStu();
//		System.out.println(stu==stu2);
		
		String javaScore = stu2.getJavaScore();
		System.out.println(javaScore);
		
		//HashMap
		Map<String,String> map = new HashMap<String,String>();
		map.put("a", "java300");
		map.put("b", "��ʿ��javase");
		
		Set<Entry<String,String>> entrySet = map.entrySet();
		//��map����entrySet
		
		for(Entry<String,String> entry : entrySet){
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"-->"+value);
		}
	}
}
