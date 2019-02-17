package testCollections.QueueEnumeration;

import java.util.StringTokenizer;

/**
 * Enumeration子类
 * StringTokenizer:类似于String split() 字符串的分割
 * 但不支持正则表达式 （split()支持正则表达式0）
 * 
 * StringTokenizer(String str, String delim)//delim分隔符，默认为空
 * 
 * @author yinyiliang
 *
 */
public class TestEnumeration02 {

	public static void main(String[] args) {
		String emailStr = "bjsxt@163.com;bjsxt@qq.com;bjsxt@sohu.com";
		StringTokenizer token = new StringTokenizer(emailStr,";");
		//遍历获取
		while(token.hasMoreElements()){
			System.out.println(token.nextElement());
		}
	}
	
}
