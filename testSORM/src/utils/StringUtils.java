package utils;
/**
 * 封装了字符串查询的常用操作
 */
public class StringUtils {

	public static String firstChar2UpperCase(String str) {
		//abcd->Abcd
		
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
