package teststringbuilder;

public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); //�ַ����鳤��Ĭ�ϳ�ʼΪ16
		StringBuilder sb1 = new StringBuilder(32); //�ַ����鳤�ȳ�ʼΪ32
		StringBuilder sb2 = new StringBuilder("abcd"); //�ַ����鳤�ȳ�ʼΪ4+16, value[]={'a','b','c','d',\u0000,\u0000...}
		sb2.append("efg");
		sb2.append(true).append(321).append("���"); //ͨ��return thisʵ�ַ�����
		System.out.println(sb2);
	}
}
