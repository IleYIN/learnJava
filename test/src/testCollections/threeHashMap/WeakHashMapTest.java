package testCollections.threeHashMap;

import java.util.WeakHashMap;

/**
 * WeakHashMap ��Ϊ������  gc������������
 * @author yinyiliang
 *
 */
public class WeakHashMapTest {

	public static void main(String[] args) {
		
		WeakHashMap<String, String> map = new WeakHashMap<String, String>();
		//��������
		map.put("abc", "A");
		map.put("d", "TEST");
		map.put(new String("efghi"), "C");
		map.put(new String("jklmn"), "D");
		
		//֪ͨ����
		System.gc();
		System.runFinalization();//�����ù��������������ջ��ƾͻ���շǹ������
		
		System.out.println(map.size());
		//�����ض��󲻻����       new�����Ķ���ʹ��WeakHashMap��gc����ʱ�ᱻ����
	}
}
