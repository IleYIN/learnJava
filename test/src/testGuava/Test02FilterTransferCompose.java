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
 * ����ʽ��� ������
 * Predicate
 * Function
 * 
 * ����Collections2.filter������ ֮������Ҫ�Ķ���
 * ����Collections2.transfer()ת��
 * ����Functions.compose()���ʽ�������
 * 
 * @author yinyiliang
 *
 */
public class Test02FilterTransferCompose {

	public static void main(String[] args) {
	
		//���ʽ�������
		//ȷ�������е��ַ������Ȳ�����5���������н�ȡ����ȫ����д
		List<String> list = Lists.newArrayList("good","happiness","sadness");
		
		//ȷ�������е��ַ������Ȳ�����5���������н�ȡ
		Function<String,String> f1 = new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.length()>5?input.substring(0, 5):input;
			}
			
		};
	
		//ȫ����д
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
	 * ת��
	 */
	public static void testFunction(){
		//����ת��
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(1000000L);
		timeSet.add(99999999999999L);
		timeSet.add(2000000000L);
		
		Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long,String>(){

			@Override
			public String apply(Long input) {//��дʱ���ܽ���ԭ����Ȩ�� public
				return new SimpleDateFormat("yyyy-MM-dd").format(input);
			}
			
		});
		
		for (String str:timeStrCol){
			System.out.println(str);
		}
		
	}
	
	
	
	/**
	 * ������
	 */
	public static void testFilter(){
		//����List ��̬��ʼ��
		List<String> list = Lists.newArrayList("mom","dad","star","satelite");
		
		//�ҳ�����palindrome backwords mirror words ǰ����ͺ���ǰ��һ���ĵ���
		
		//���һ����ֻʹ��һ�Σ��������Ķ���Ҳֻʹ��һ�Σ������ʹ�������ڲ���-->�����ڲ���ͬʱ��������
		Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>(){

			@Override
			public boolean apply(String input) {
				// ҵ���߼�
				return new StringBuilder(input).reverse().toString().equals(input);
			}
			
		});
		
		for(String str:palindromeList){
			System.out.println(str);
		}
	}
}
