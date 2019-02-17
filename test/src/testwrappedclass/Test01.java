package testwrappedclass;//包装类

public class Test01 {
	public static void main(String[] args) {
		Integer i = new Integer(1000); 
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toHexString(i));
		Integer i2 = Integer.parseInt("234");//把字符串转成数字
		System.out.println(i2+10);
		Integer i3 = new Integer("333");
		System.out.println(i3.intValue());//这样也是把字符串转成数字
		
		String str = 234 + ""; //数字转字符串
		
	}
}
 