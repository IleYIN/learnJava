package testGuava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * ֻ������ ImmutableList
 * 
 * @author yinyiliang
 *
 */
public class Test01ImmutableList {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		//��ԭ�е�list���а�װ���൱��ԭ��List��һ����ͼ������
		List<String> readList = Collections.unmodifiableList(list);
//		readList.add("d");//java.lang.UnsupportedOperationException
		
		list.add("d");//�ı�ԭ��list ��ͼҲ��ı�  ���readListֻ�����ò�����ȫ
		
		//Guava
		//��ʼ��List
		List<String> immutableList = ImmutableList.of("a","b","c");
		immutableList.add("d");//java.lang.UnsupportedOperationException
		//guava��ֻ������ ��ȫ�ɿ� ������Լ�
	}
}
