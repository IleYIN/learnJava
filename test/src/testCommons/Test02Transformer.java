package testCommons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

/**
 * 
 * 函数式编程
 * -->解耦 业务判断和容器分开
 * 
 * Transformer类型转换
 * new Transformer()+transform方法重写
 * 
 * SwitchTransformer(predicates[], transformers[] )
 * CollectionUtils.collect(要改变的容器，新转换器)
 * 
 * @author yinyiliang
 *
 */
public class Test02Transformer {

	public static void main(String[] args) {

		System.out.println("-------自定义类型转换-------");
		
		//判别式
		Predicate<Employee> isLower = new Predicate<Employee>(){

			@Override
			public boolean evaluate(Employee emp) {
				return emp.getSalary()<10000;
			}
			
		};
		
		Predicate<Employee> isHigher = new Predicate<Employee>(){

			@Override
			public boolean evaluate(Employee emp) {
				return emp.getSalary()>=10000;
			}
			
		};
		
		Predicate[] pres = {isLower, isHigher};
		
		
		//转换
		Transformer<Employee, Level> lowtrans = new Transformer<Employee, Level>(){

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(),"低工资");
			}
			
		};
		
		Transformer<Employee, Level> hightrans = new Transformer<Employee, Level>(){

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(),"高工资");
			}
			
		};
		
		Transformer[] trans = {lowtrans, hightrans};
		
		
		//连接转换器和判别式,一一对应的对满足pres的元素进行trans
		Transformer switchTrans = new SwitchTransformer(pres, trans, null);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("老马",1000000));
		list.add(new Employee("老王",1000));
		list.add(new Employee("老李",800));
		
		Collection<Level> levelList = CollectionUtils.collect(list, switchTrans);
		
		//遍历容器
		Iterator<Level> levelIt = levelList.iterator();
		while(levelIt.hasNext()){
			System.out.println(levelIt.next());
		}
	
	}
	
	
	/**
	 * 内置类型的转化
	 */
	
	public static void transDate(){
		
		System.out.println("---内置类型转换 长整型时间日期转成指定格式的字符串---");
		
		Transformer<Long,String> trans = new Transformer<Long,String>(){
			//类型转换器
			
			@Override
			public String transform(Long input) {
				return new SimpleDateFormat("yyyy年MM月dd日").format(input);
			}
			
		};
		
		List<Long> list = new ArrayList<Long>();
		list.add(999999999L);
		list.add(300000000000L);
		
		//工具类中介
		Collection<String> result = CollectionUtils.collect(list, trans);
		for(String str:result){
			System.out.println(str);
		}
	}
}
