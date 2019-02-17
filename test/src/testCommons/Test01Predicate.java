package testCommons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;

/**
 * ����ʽ���֮Predicate ����
 * ��װ�������б�ʽ if..else���
 * 
 * new EqualPredicate<����>(ֵ)
 * ����EqualPredicate.equalPredicate(ֵ)
 * 
 * 
 * ����ֵ���ж�
 * �ǿ�
 * NotNullPredicate.INSTANCE;
 * NotNullPredicate.notNullPredicate();
 * 
 * ���
 * EqualPredicate.equalPredicate
 * 
 * Ψһ
 * UniquePredicate.uniquePredicate();
 * 
 * PredicatedXxx.predicatedXxx(����,�ж�)  PredicatedList.predicatedList(����,�ж�) 
 * 
 * 
 * �Զ��� new Predicate() {�����ڲ���+��дevaluate����}
 * Predicate�൱��if..else�����
 * �жϵĽ���
 * 
 * 	PredicateUtils.allPredicate(,);//�ң�ȫ��������
 *  PredicateUtils.andPredicate(,);//�ң�����������
 *	PredicateUtils.anyPredicate(,);//����һ�����㼴Ϊtrue
 * 
 * @author yinyiliang
 *
 */
public class Test01Predicate {

	public static void main(String[] args) {
		
		System.out.println("-----�Զ����ж�-----");
		Predicate<String> selfPre = new Predicate<String>(){

			@Override
			public boolean evaluate(String object) {
				//�жϳ���
				return object.length()>=5 && object.length()<=20;
			}
			
		};
		
		Predicate notNull = NotNullPredicate.notNullPredicate();
		
		//����ж�
		Predicate allPre = PredicateUtils.allPredicate(selfPre,notNull);//�ң�ȫ��������
//		PredicateUtils.andPredicate(selfPre,notNull);//�ң�����������
//		PredicateUtils.anyPredicate(selfPre,notNull);//����һ�����㼴Ϊtrue
		
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), allPre);
		list.add("bjsxt");
		
//		list.add(null);//java.lang.NullPointerException
		//���ĳ�Predicate allPre = PredicateUtils.allPredicate(notNull,selfPre); ��list.add(null);//IllegalArgumentException
		
//		list.add("bj");//java.lang.IllegalArgumentException
	}
	
	
	
	public static void judgeUnique(){
		
		System.out.println("-----�ж�Ψһ��-----");
	
		Predicate<Long> uniquePre = UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), uniquePre);
		list.add(100L);
		list.add(200L);
//		list.add(200L);// java.lang.IllegalArgumentException
		
		
	}
	
	
	
	public static void judgeNotNull(){
		
	System.out.println("-----�жϷǿ�-----");
		
		//�������ֶ�������
//		Predicate notNull = NotNullPredicate.INSTANCE;
		Predicate notNull = NotNullPredicate.notNullPredicate();
		
		String str = "bjs";
		System.out.println(notNull.evaluate(str));
		
		str = null;
		System.out.println(notNull.evaluate(str));
		//����ǿ�Ϊtrue������Ϊfalse
				
		//�������ֵ���ж�
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), notNull);
		list.add(10000L);
//		list.add(null);// java.lang.IllegalArgumentException
		
	}
	
	public static void judgeEqual(){
		
		System.out.println("-----�ж����-----");

		//Predicate<String> pre = new EqualPredicate<String>("bjsxt");
		//����ʹ�����������������
		Predicate<String> pre = EqualPredicate.equalPredicate("bjsxt");
		boolean flag = pre.evaluate("bj");
		System.out.println(flag);
	}
}
