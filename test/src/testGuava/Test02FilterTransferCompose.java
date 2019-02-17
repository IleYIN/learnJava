package testGuava;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 函数式编程 ：解耦
 * Predicate
 * Function
 * 
 * 工具Collections2.filter过滤器 之过滤需要的东西
 * 工具Collections2.transfer()转换
 * 工具Functions.compose()组合式函数编程
 * 
 * @author yinyiliang
 *
 */
public class Test02FilterTransferCompose {

	public static void main(String[] args) {
	
		//组合式函数编程
		//确保容器中的字符串长度不超过5，超过进行截取，后全部大写
		List<String> list = Lists.newArrayList("good","happiness","sadness");
		
		//确保容器中的字符串长度不超过5，超过进行截取
		Function<String,String> f1 = new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.length()>5?input.substring(0, 5):input;
			}
			
		};
	
		//全部大写
		Function<String,String> f2 = new Function<String,String>(){
			
			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}
			
		};
		
		//String-->f2(f1(String))
		Function<String,String> f = Functions.compose(f1, f2);
		Collection<String> resultCol = Collections2.transform(list, f);
		
		for(String str:resultCol){
			System.out.println(str);
		}
		
	}
	
	
	
	/**
	 * 转换
	 */
	public static void testFunction(){
		//类型转换
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(1000000L);
		timeSet.add(99999999999999L);
		timeSet.add(2000000000L);
		
		Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long,String>(){

			@Override
			public String apply(Long input) {//重写时不能降低原来的权限 public
				return new SimpleDateFormat("yyyy-MM-dd").format(input);
			}
			
		});
		
		for (String str:timeStrCol){
			System.out.println(str);
		}
		
	}
	
	
	
	/**
	 * 过滤器
	 */
	public static void testFilter(){
		//创建List 静态初始化
		List<String> list = Lists.newArrayList("mom","dad","star","satelite");
		
		//找出回文palindrome backwords mirror words 前往后和后往前是一样的单词
		
		//如果一个类只使用一次，且这个类的对象也只使用一次，则可以使用匿名内部类-->匿名内部类同时创建对象
		Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>(){

			@Override
			public boolean apply(String input) {
				// 业务逻辑
				return new StringBuilder(input).reverse().toString().equals(input);
			}
			
		});
		
		for(String str:palindromeList){
			System.out.println(str);
		}
	}
}
