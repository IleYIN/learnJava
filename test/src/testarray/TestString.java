package testarray;

public class TestString {
	public static void main(String[] args) {
		String str = "abcd";
		String str2 = new String("abcd");
		String str3 = "adbcdd";
	
		System.out.println(str2.charAt(2));
		System.out.println(str2.equals(str));//�Ƚ������Ƿ����
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
		System.out.println(str5.trim());//ȥ����β�ո�
		
		String str6 = "  aabdd ";
		System.out.println(str6.toCharArray());//�������ַ����飬����Ϊԭ�ַ�������
		
		System.out.println("ABc".equalsIgnoreCase("abc"));//���Դ�Сд
		
		
		System.out.println("abcdef".toUpperCase());
		
		System.out.println("############");
//		String gh = "a"; //gh���ָ����Ա䣬����"a"���������final�Ĳ��ܱ�
//		for (int i=0; i<10;i++) {  //��ռ�ռ� ��11������
//			gh += i;
//		}
		
		StringBuilder gh = new StringBuilder("a");
		for (int i=0; i<10; i++) {
			gh.append(i); //ֻ����������"a"��new
		}
		System.out.println(gh);
		
	}

}

