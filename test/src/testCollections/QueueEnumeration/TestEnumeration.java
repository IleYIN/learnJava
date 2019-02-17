package testCollections.QueueEnumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration
 * 现在多使用Iterator代替
 * 
 * 判断 hasMoreElements()
 * 获取nextElement()
 * 
 * Vector的elements()方法
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
		
		//遍历该Vector
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
