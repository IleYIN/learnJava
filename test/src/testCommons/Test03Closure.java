package testCommons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

/**
 * ����ʽ���Closure�հ� ��װ�ض���ҵ����
 * 1��Closure
 * 2��CollectionUtils.forAllDo(����,���������)
 * 
 * 3�� IfClosure��ѡһ����     IfClosure.ifClosure(predicate, trueClosure, falseClosure)
 * 
 * 4�� WhileClosure   WhileClosure.whileClosure(predicate, closure, false);
 *				//false��ʾwhile�ṹ���жϺ�ִ��     true��ʾdo..while��ִ�к��ж�
 *
 * 5��ChainedClosure.chainedClosure(closure1,closure2...)
 * 
 * @author yinyiliang
 *
 */
public class Test03Closure {

	
	public static void main(String[] args) {
//		basic();
		ifClosure();
//		whileClosure();
		chainedClosure();
	}
	
	
	/**
	 * ȷ�����е�Ա�����ʶ�����10000������Ͳ���ѭ����1.2ֱ���ﵽ10000���Ѵ��ڵ��򲻱�
	 */
	public static void whileClosure(){
		
		//����
				List<Employee> empList = new ArrayList<Employee>();
				empList.add(new Employee("bjsxt",20000));
				empList.add(new Employee("is",10000));
				empList.add(new Employee("good",5000));
				
				//ҵ����
				Closure<Employee> clos = new Closure<Employee>(){

					@Override
					public void execute(Employee input) {
						input.setSalary(input.getSalary()*1.2);//������1.2��
					}
					
				};
				
				
				//�ж�
				Predicate<Employee> empPre = new Predicate<Employee>(){

					@Override
					public boolean evaluate(Employee emp) {
						return emp.getSalary() < 10000;
					}
					
				};
				
				Closure<Employee> whileClos = WhileClosure.whileClosure(empPre, clos, false);
				//false��ʾwhile�ṹ���жϺ�ִ��     true��ʾdo..while��ִ�к��ж�
				
				
				
				//�����ݺ�ҵ����й���
				//������
				CollectionUtils.forAllDo(empList, whileClos);
				
				Iterator<Employee> empListIt = empList.iterator();
				while(empListIt.hasNext()){
					System.out.println(empListIt.next());
				}
				
	}
	
	
	

	/**
	 * ��ѡһ����,�ȿ��ۿ�������ۿ������9�ۣ���������ټ�20
	 */
	public static void chainedClosure(){
		
		List<Goods> goodsList =new ArrayList<Goods>();
		goodsList.add(new Goods("javase cours",120,true));
		goodsList.add(new Goods("javaee cours",100,false));
		goodsList.add(new Goods("new advanced technology",90,false));
		
		//���ټ�20
		Closure<Goods> subtract = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		
		
		//����
		Closure<Goods> discount = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.isDiscount())
				input.setPrice(input.getPrice()*0.9);
			}
			
		};
		
		
		//��ʽ����
		Closure<Goods> chainedClo = ChainedClosure.chainedClosure(discount, subtract);
		
		CollectionUtils.forAllDo(goodsList, chainedClo);
		
		for(Goods temp:goodsList){
			System.out.println(temp);
		}
		
		
	}
	
	
	
	
	/**
	 * ��ѡһ����,������ۿ������9�ۣ��������ټ�20
	 */
	public static void ifClosure(){
		
		
		List<Goods> goodsList =new ArrayList<Goods>();
		goodsList.add(new Goods("javase cours",120,true));
		goodsList.add(new Goods("javaee cours",100,false));
		goodsList.add(new Goods("new advanced technology",90,false));
		
		//���ټ�20
		Closure<Goods> subtract = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		
		
		//����
		Closure<Goods> discount = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
//				if(input.isDiscount())
				input.setPrice(input.getPrice()*0.9);
			}
			
		};
		
		
		
		
		//�ж��Ƿ����ۿ�  
		Predicate<Goods> preDis = new Predicate<Goods>(){

			@Override
			public boolean evaluate(Goods goods) {
				return goods.isDiscount();
			}
			
		};
		
		
		//��ѡһ
		Closure<Goods> ifClo = IfClosure.ifClosure(preDis, discount, subtract);
//		IfClosure.ifClosure(predicate, trueClosure, falseClosure)
		
		CollectionUtils.forAllDo(goodsList, ifClo);
		
		for(Goods temp:goodsList){
			System.out.println(temp);
		}
		
		
	}
	
	
	
	/**
	 * ��������
	 */
	public static void basic(){
		
		//����
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("bjsxt",20000));
		empList.add(new Employee("is",10000));
		empList.add(new Employee("good",5000));
		
		//ҵ����
		Closure<Employee> clos = new Closure<Employee>(){

			@Override
			public void execute(Employee input) {
				input.setSalary(input.getSalary()*1.2);//������1.2��
			}
			
		};
		
		
		//�����ݺ�ҵ����й���
		//������
		CollectionUtils.forAllDo(empList, clos);
		
		Iterator<Employee> empListIt = empList.iterator();
		while(empListIt.hasNext()){
			System.out.println(empListIt.next());
		}
		
	}
}
