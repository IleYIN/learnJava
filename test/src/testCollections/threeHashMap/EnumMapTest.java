package testCollections.threeHashMap;

import java.util.EnumMap;

/**
 * 要求键为枚举
 * @author yinyiliang
 *
 */
public class EnumMapTest {

	public static void main(String[] args) {
		
		EnumMap<Season,String> map = new EnumMap<Season,String>(Season.class);
		
		//存放值
		map.put(Season.SPRING, "春困");
		map.put(Season.SUMMER, "夏无力");
		map.put(Season.AUTUMN, "秋乏");
		map.put(Season.WINTER, "冬眠");
		
		System.out.println(map.size());
	}
}
enum Season{
	SPRING, SUMMER, AUTUMN, WINTER
}
