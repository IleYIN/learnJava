package testCollections.QueueEnumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration
 * ���ڶ�ʹ��Iterator����
 * 
 * �ж� hasMoreElements()
 * ��ȡnextElement()
 * 
 * Vector��elements()����
 * 
 * @author yinyiliang
 *
 */
public class TestEnumeration {

	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		//������Vector
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
