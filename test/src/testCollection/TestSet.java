package testCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * ����Set�ĳ��÷���
 * 
 * @author yinyiliang
 *
 */
public class TestSet {
	public static void main(String[] args) {
		
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new String("aaa"));
//		set.remove("aaa");
//		set.clear();
		System.out.println(set.size());//set��û��get��Ϊû��˳��
		//��Ȼ����ͬһ�����󣬵�equals��true�ģ����ԻḲ�ǣ�setԴ�����map�йأ�map��key�����ظ�
		
		System.out.println(set.contains("aaa"));
	}
}
