package testCommons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * ���ϲ��� 
 * 
 * ���� CollectionUtils.union(set1, set2)
 * ���� CollectionUtils.intersection(set1, set2)��CollectionUtils.retainAll(set1, set2)
 * �CollectionUtils.subtract(set1, set2)
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test04IntersectionUnionDiff {

	public static void main(String[] args) {
		
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		//����
		System.out.println("---------Union--------");
		Collection<Integer> col = CollectionUtils.union(set1, set2);
		
		for(Integer temp:col){
			System.out.println(temp);
		}
		
		//����
		System.out.println("---------Intersection-------");
//		Collection<Integer> colInt = CollectionUtils.intersection(set1, set2);
		//�����������
		Collection<Integer> colInt = CollectionUtils.retainAll(set1, set2);
		//Returns a collection containing all the elements in collection that are also in retain
		
		for(Integer temp:colInt){
			System.out.println(temp);
		}
		
		
		//�
		System.out.println("---------Subtract�-------");
		Collection<Integer> colSub = CollectionUtils.subtract(set1, set2);
		
		for(Integer temp:colSub){
			System.out.println(temp);
		}
	}
}
