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
 * 函数式编程Closure闭包 封装特定的业务功能
 * 1、Closure
 * 2、CollectionUtils.forAllDo(容器,功能类对象)
 * 
 * 3、 IfClosure二选一操作     IfClosure.ifClosure(predicate, trueClosure, falseClosure)
 * 
 * 4、 WhileClosure   WhileClosure.whileClosure(predicate, closure, false);
 *				//false表示while结构先判断后执行     true表示do..while先执行后判断
 *
 * 5、ChainedClosure.chainedClosure(closure1,closure2...)
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
	 * 确保所有的员工工资都大于10000，否则就不断循环乘1.2直到达到10000，已大于的则不变
	 */
	public static void whileClosure(){
		
		//数据
				List<Employee> empList = new ArrayList<Employee>();
				empList.add(new Employee("bjsxt",20000));
				empList.add(new Employee("is",10000));
				empList.add(new Employee("good",5000));
				
				//业务功能
				Closure<Employee> clos = new Closure<Employee>(){

					@Override
					public void execute(Employee input) {
						input.setSalary(input.getSalary()*1.2);//工资涨1.2倍
					}
					
				};
				
				
				//判断
				Predicate<Employee> empPre = new Predicate<Employee>(){

					@Override
					public boolean evaluate(Employee emp) {
						return emp.getSalary() < 10000;
					}
					
				};
				
				Closure<Employee> whileClos = WhileClosure.whileClosure(empPre, clos, false);
				//false表示while结构先判断后执行     true表示do..while先执行后判断
				
				
				
				//将数据和业务进行关联
				//工具类
				CollectionUtils.forAllDo(empList, whileClos);
				
				Iterator<Employee> empListIt = empList.iterator();
				while(empListIt.hasNext()){
					System.out.println(empListIt.next());
				}
				
	}
	
	
	

	/**
	 * 二选一操作,先看折扣如果有折扣则进行9折，如果满百再减20
	 */
	public static void chainedClosure(){
		
		List<Goods> goodsList =new ArrayList<Goods>();
		goodsList.add(new Goods("javase cours",120,true));
		goodsList.add(new Goods("javaee cours",100,false));
		goodsList.add(new Goods("new advanced technology",90,false));
		
		//满百减20
		Closure<Goods> subtract = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		
		
		//打折
		Closure<Goods> discount = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.isDiscount())
				input.setPrice(input.getPrice()*0.9);
			}
			
		};
		
		
		//链式操作
		Closure<Goods> chainedClo = ChainedClosure.chainedClosure(discount, subtract);
		
		CollectionUtils.forAllDo(goodsList, chainedClo);
		
		for(Goods temp:goodsList){
			System.out.println(temp);
		}
		
		
	}
	
	
	
	
	/**
	 * 二选一操作,如果有折扣则进行9折，否则满百减20
	 */
	public static void ifClosure(){
		
		
		List<Goods> goodsList =new ArrayList<Goods>();
		goodsList.add(new Goods("javase cours",120,true));
		goodsList.add(new Goods("javaee cours",100,false));
		goodsList.add(new Goods("new advanced technology",90,false));
		
		//满百减20
		Closure<Goods> subtract = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		
		
		//打折
		Closure<Goods> discount = new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
//				if(input.isDiscount())
				input.setPrice(input.getPrice()*0.9);
			}
			
		};
		
		
		
		
		//判断是否有折扣  
		Predicate<Goods> preDis = new Predicate<Goods>(){

			@Override
			public boolean evaluate(Goods goods) {
				return goods.isDiscount();
			}
			
		};
		
		
		//二选一
		Closure<Goods> ifClo = IfClosure.ifClosure(preDis, discount, subtract);
//		IfClosure.ifClosure(predicate, trueClosure, falseClosure)
		
		CollectionUtils.forAllDo(goodsList, ifClo);
		
		for(Goods temp:goodsList){
			System.out.println(temp);
		}
		
		
	}
	
	
	
	/**
	 * 基本操作
	 */
	public static void basic(){
		
		//数据
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("bjsxt",20000));
		empList.add(new Employee("is",10000));
		empList.add(new Employee("good",5000));
		
		//业务功能
		Closure<Employee> clos = new Closure<Employee>(){

			@Override
			public void execute(Employee input) {
				input.setSalary(input.getSalary()*1.2);//工资涨1.2倍
			}
			
		};
		
		
		//将数据和业务进行关联
		//工具类
		CollectionUtils.forAllDo(empList, clos);
		
		Iterator<Employee> empListIt = empList.iterator();
		while(empListIt.hasNext()){
			System.out.println(empListIt.next());
		}
		
	}
}
