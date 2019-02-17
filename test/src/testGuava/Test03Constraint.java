package testGuava;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;

/**
 * 加入约束条件：
 * 非空  长度验证
 * Constraint
 * Preconditions
 * Constraints
 * 
 * @author yinyiliang
 *
 */
public class Test03Constraint {

	public static void main(String[] args) {
		Set<String> sets = Sets.newHashSet();
		//创建约束
		Constraint<String> constraint = new Constraint<String>(){

			@Override
			public String checkElement(String element) {
				//非空验证
				Preconditions.checkNotNull(element);
				//长度验证 5-20位的字符串
				Preconditions.checkArgument(element.length()>=5 && element.length()<=20);
				return element;
			}
			
		};
		
		Set<String> cs = Constraints.constrainedSet(sets, constraint);
//		cs.add(null);//java.lang.NullPointerException
//		cs.add("good");//java.lang.IllegalArgumentException
		cs.add("bjsxt");
		
		for(String str:cs){
			System.out.println(str);
		}
	}
}
