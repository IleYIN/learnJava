package testSort.innerType;
/**
 * ���������������͵ıȽ�
 * @author yinyiliang
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Integer a;//���ݻ����������ʹ�С
		Character ch;//����Unicode����˳��
		String str = "abc";
		String str2 = "abc123";
		System.out.println(str.compareTo(str2));//�ַ���ͬ�Ļ��Ƚϳ��Ȳ�
		
		str2 = "acg";
		System.out.println(str.compareTo(str2));//�ַ���ͬ�Ļ��Ƚϵ�һ����ͬ�ַ��Ĳ�
		
		java.util.Date d;//�������ڵĳ����ͱȽ�
	}
}
