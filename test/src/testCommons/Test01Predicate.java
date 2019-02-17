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
 * 函数式编程之Predicate 断言
 * 封装条件或判别式 if..else替代
 * 
 * new EqualPredicate<类型>(值)
 * 或者EqualPredicate.equalPredicate(值)
 * 
 * 
 * 容器值的判断
 * 非空
 * NotNullPredicate.INSTANCE;
 * NotNullPredicate.notNullPredicate();
 * 
 * 相等
 * EqualPredicate.equalPredicate
 * 
 * 唯一
 * UniquePredicate.uniquePredicate();
 * 
 * PredicatedXxx.predicatedXxx(容器,判断)  PredicatedList.predicatedList(容器,判断) 
 * 
 * 
 * 自定义 new Predicate() {匿名内部类+重写evaluate方法}
 * Predicate相当于if..else的替代
 * 判断的解耦
 * 
 * 	PredicateUtils.allPredicate(,);//且，全部都满足
 *  PredicateUtils.andPredicate(,);//且，两个都满足
 *	PredicateUtils.anyPredicate(,);//或，有一个满足即为true
 * 
 * @author yinyiliang
 *
 */
public class Test01Predicate {

	public static void main(String[] args) {
		
		System.out.println("-----自定义判断-----");
		Predicate<String> selfPre = new Predicate<String>(){

			@Override
			public boolean evaluate(String object) {
				//判断长度
				return object.length()>=5 && object.length()<=20;
			}
			
		};
		
		Predicate notNull = NotNullPredicate.notNullPredicate();
		
		//组合判断
		Predicate allPre = PredicateUtils.allPredicate(selfPre,notNull);//且，全部都满足
//		PredicateUtils.andPredicate(selfPre,notNull);//且，两个都满足
//		PredicateUtils.anyPredicate(selfPre,notNull);//或，有一个满足即为true
		
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), allPre);
		list.add("bjsxt");
		
//		list.add(null);//java.lang.NullPointerException
		//若改成Predicate allPre = PredicateUtils.allPredicate(notNull,selfPre); 则list.add(null);//IllegalArgumentException
		
//		list.add("bj");//java.lang.IllegalArgumentException
	}
	
	
	
	public static void judgeUnique(){
		
		System.out.println("-----判断唯一性-----");
	
		Predicate<Long> uniquePre = UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), uniquePre);
		list.add(100L);
		list.add(200L);
//		list.add(200L);// java.lang.IllegalArgumentException
		
		
	}
	
	
	
	public static void judgeNotNull(){
		
	System.out.println("-----判断非空-----");
		
		//下面两种都可以用
//		Predicate notNull = NotNullPredicate.INSTANCE;
		Predicate notNull = NotNullPredicate.notNullPredicate();
		
		String str = "bjs";
		System.out.println(notNull.evaluate(str));
		
		str = null;
		System.out.println(notNull.evaluate(str));
		//如果非空为true，否则为false
				
		//添加容器值的判断
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), notNull);
		list.add(10000L);
//		list.add(null);// java.lang.IllegalArgumentException
		
	}
	
	public static void judgeEqual(){
		
		System.out.println("-----判断相等-----");

		//Predicate<String> pre = new EqualPredicate<String>("bjsxt");
		//或者使用下面的来创建对象
		Predicate<String> pre = EqualPredicate.equalPredicate("bjsxt");
		boolean flag = pre.evaluate("bj");
		System.out.println(flag);
	}
}
