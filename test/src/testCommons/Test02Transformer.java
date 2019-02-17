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
 * ����ʽ���
 * -->���� ҵ���жϺ������ֿ�
 * 
 * Transformer����ת��
 * new Transformer()+transform������д
 * 
 * SwitchTransformer(predicates[], transformers[] )
 * CollectionUtils.collect(Ҫ�ı����������ת����)
 * 
 * @author yinyiliang
 *
 */
public class Test02Transformer {

	public static void main(String[] args) {

		System.out.println("-------�Զ�������ת��-------");
		
		//�б�ʽ
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
		
		
		//ת��
		Transformer<Employee, Level> lowtrans = new Transformer<Employee, Level>(){

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(),"�͹���");
			}
			
		};
		
		Transformer<Employee, Level> hightrans = new Transformer<Employee, Level>(){

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(),"�߹���");
			}
			
		};
		
		Transformer[] trans = {lowtrans, hightrans};
		
		
		//����ת�������б�ʽ,һһ��Ӧ�Ķ�����pres��Ԫ�ؽ���trans
		Transformer switchTrans = new SwitchTransformer(pres, trans, null);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("����",1000000));
		list.add(new Employee("����",1000));
		list.add(new Employee("����",800));
		
		Collection<Level> levelList = CollectionUtils.collect(list, switchTrans);
		
		//��������
		Iterator<Level> levelIt = levelList.iterator();
		while(levelIt.hasNext()){
			System.out.println(levelIt.next());
		}
	
	}
	
	
	/**
	 * �������͵�ת��
	 */
	
	public static void transDate(){
		
		System.out.println("---��������ת�� ������ʱ������ת��ָ����ʽ���ַ���---");
		
		Transformer<Long,String> trans = new Transformer<Long,String>(){
			//����ת����
			
			@Override
			public String transform(Long input) {
				return new SimpleDateFormat("yyyy��MM��dd��").format(input);
			}
			
		};
		
		List<Long> list = new ArrayList<Long>();
		list.add(999999999L);
		list.add(300000000000L);
		
		//�������н�
		Collection<String> result = CollectionUtils.collect(list, trans);
		for(String str:result){
			System.out.println(str);
		}
	}
}
