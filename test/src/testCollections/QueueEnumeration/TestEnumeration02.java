package testCollections.QueueEnumeration;

import java.util.StringTokenizer;

/**
 * Enumeration����
 * StringTokenizer:������String split() �ַ����ķָ�
 * ����֧��������ʽ ��split()֧��������ʽ0��
 * 
 * StringTokenizer(String str, String delim)//delim�ָ�����Ĭ��Ϊ��
 * 
 * @author yinyiliang
 *
 */
public class TestEnumeration02 {

	public static void main(String[] args) {
		String emailStr = "bjsxt@163.com;bjsxt@qq.com;bjsxt@sohu.com";
		StringTokenizer token = new StringTokenizer(emailStr,";");
		//������ȡ
		while(token.hasMoreElements()){
			System.out.println(token.nextElement());
		}
	}
	
}
