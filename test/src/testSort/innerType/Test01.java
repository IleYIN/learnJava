package testSort.innerType;
/**
 * 内置引用数据类型的比较
 * @author yinyiliang
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Integer a;//根据基本数据类型大小
		Character ch;//根据Unicode编码顺序
		String str = "abc";
		String str2 = "abc123";
		System.out.println(str.compareTo(str2));//字符相同的话比较长度差
		
		str2 = "acg";
		System.out.println(str.compareTo(str2));//字符不同的话比较第一个不同字符的差
		
		java.util.Date d;//根据日期的长整型比较
	}
}
