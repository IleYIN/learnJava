package utils;
/**
 * ��װ���ַ�����ѯ�ĳ��ò���
 */
public class StringUtils {

	public static String firstChar2UpperCase(String str) {
		//abcd->Abcd
		
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
