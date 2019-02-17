package testGuava;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * ͳ�Ƶ��ʳ��ֵĴ���((��testHashMap)(��testCommons-->Test08))
 * 
 * 1��HashMap �ּ�洢+�������˼ά-->�����ж�
 * 2��Guava�ṩ��Multiset: ����+���ظ�  .count()  ��ǿ�˿ɶ���+������
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test05Multiset {

	public static void main(String[] args) {
		String str = "this is a cat and that is a mouse where is the food";
		
		//�ָ��ַ���
		String[] strArray = str.split(" ");
		
		//�洢��Multiset��
		Multiset<String> set = HashMultiset.create();
		
		for (String strTemp : strArray){
			set.add(strTemp);
		}
		
		//��ȡ���еĵ���Set
		Set<String> letters = set.elementSet();
		for(String temp:letters){
			System.out.println(temp+"-->"+set.count(temp));
		}
	}
}
