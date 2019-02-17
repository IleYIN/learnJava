package testSort.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * binarySearch(List<? extends Comparable<? super T>> list, T key)
 * ���ַ�������Ҫ��������
 * sort����
 * reverse(List<?> list) ��ת
 * shuffle(List<?> list) ϴ��
 * swap(List<?> list, int i, int j) ����
 * @author yinyiliang
 *
 */
public class CollectionsTest01 {

	public static void main(String[] args) {
	
		List<Integer> cards = new ArrayList<Integer>();
		//shuffleϴ�� ģ�⶷����
		for (int i=0; i<=54; i++){
			cards.add(i);
		}
		//ϴ��
		Collections.shuffle(cards);
		//���η���
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		List<Integer> last = new ArrayList<Integer>();
		//�����ŵ��ƣ�ÿ�ַ�������
		for(int i=0;i<51;i+=3){
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		
		System.out.println("��һ���ˣ�"+p1);
		System.out.println("�ڶ����ˣ�"+p2);
		System.out.println("�������ˣ�"+p3);
		System.out.println("���ƣ�"+last);
	}
	
	public static void test1(){
		//��ת
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.reverse(list);//��ת
		System.out.println(list);
	}
}
