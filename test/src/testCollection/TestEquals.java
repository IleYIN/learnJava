package testCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEquals {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		String s1 = new String("aaa");
		list.add(s1);
		list.add(s1);
		System.out.println(list.size());
		
		Map map = new HashMap();
		//�������ظ������򸲸�
		map.put(s1, "AAA");
		map.put(s1, "BBB");
		System.out.println(map.get("aaa"));
	}
}
//set���� �����ظ� equals������Ϊtrue