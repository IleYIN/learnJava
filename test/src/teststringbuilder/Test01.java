package teststringbuilder;

public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); //字符数组长度默认初始为16
		StringBuilder sb1 = new StringBuilder(32); //字符数组长度初始为32
		StringBuilder sb2 = new StringBuilder("abcd"); //字符数组长度初始为4+16, value[]={'a','b','c','d',\u0000,\u0000...}
		sb2.append("efg");
		sb2.append(true).append(321).append("随便"); //通过return this实现方法链
		System.out.println(sb2);
	}
}
