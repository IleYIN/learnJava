package testCollections.synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ʹ��Collections����ͬ������
 * 
 * @author yinyiliang
 *
 */
public class Test01synList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		//list����ͬ��
		List<String> synList = Collections.synchronizedList(list);
		System.out.println("�̰߳�ȫ��list�������");
	}
}
