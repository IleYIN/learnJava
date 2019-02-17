package testCollections.threeHashMap;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * ���÷��ࣺǿ �� �� ��
 * ǿ��������
 * 
 * @author yinyiliang
 *
 */
public class TestRef {

	public static void main(String[] args) {
		
		
		String str = new String( "He's very good.");//new�����Ķ����ڶ��У�������
		
		//������ �������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		
		//�Ͽ�����
		str = null;
		
		//֪ͨ����
		System.gc();
		System.runFinalization();//�����ù��������������ջ��ƾͻ���շǹ������
		System.out.println("gc���к�"+wr.get());//���ֶ����Ѿ�������
	}
	
	
	public static void testStrong(){
		
		String str = "He's very good.";//�ַ��������� �������ܻ��գ�
		
		//������ �������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		
		//�Ͽ�����
		str = null;
		
		//֪ͨ����
		System.gc();
		System.runFinalization();
		System.out.println("gc���к�"+wr.get());//���ֶ���ͬ�����ڣ����ܻ���
	}
}
