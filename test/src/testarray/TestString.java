package testarray;

public class TestString {
	public static void main(String[] args) {
		String str = "abcd";
		String str2 = new String("abcd");
		String str3 = "adbcdd";
	
		System.out.println(str2.charAt(2));
		System.out.println(str2.equals(str));//比较内容是否相等
		System.out.println(str==str2);
		System.out.println(str==str3);
		
		System.out.println(str3.indexOf('d'));
		System.out.println(str3.lastIndexOf('d'));
		System.out.println(str3.indexOf('f'));
		System.out.println(str3.startsWith("d"));
		System.out.println(str3.endsWith("dd"));
		System.out.println(str.substring(2));
		System.out.println(str.replace('a','*'));
		
		String str4 = "a,bcd,ef";
		
		String[] strArray = str4.split(",");
		
		for(int i=0;i<strArray.length;i++)
		System.out.println(strArray[i]);
		
		String str5 = "  a bcd  ef   ";
		System.out.println(str5.trim());//去除首尾空格
		
		String str6 = "  aabdd ";
		System.out.println(str6.toCharArray());//返回新字符数组，内容为原字符串内容
		
		System.out.println("ABc".equalsIgnoreCase("abc"));//忽略大小写
		
		
		System.out.println("abcdef".toUpperCase());
		
		System.out.println("############");
//		String gh = "a"; //gh这个指针可以变，但是"a"这个数组是final的不能变
//		for (int i=0; i<10;i++) {  //很占空间 有11个对象
//			gh += i;
//		}
		
		StringBuilder gh = new StringBuilder("a");
		for (int i=0; i<10; i++) {
			gh.append(i); //只有两个对象，"a"和new
		}
		System.out.println(gh);
		
	}

}

