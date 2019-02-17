package testCollections.threeHashMap;

import java.util.EnumMap;

/**
 * Ҫ���Ϊö��
 * @author yinyiliang
 *
 */
public class EnumMapTest {

	public static void main(String[] args) {
		
		EnumMap<Season,String> map = new EnumMap<Season,String>(Season.class);
		
		//���ֵ
		map.put(Season.SPRING, "����");
		map.put(Season.SUMMER, "������");
		map.put(Season.AUTUMN, "�﷦");
		map.put(Season.WINTER, "����");
		
		System.out.println(map.size());
	}
}
enum Season{
	SPRING, SUMMER, AUTUMN, WINTER
}
