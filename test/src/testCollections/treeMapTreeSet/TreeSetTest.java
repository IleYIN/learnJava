package testCollections.treeMapTreeSet;
/**
 * 提供了解耦的方式：业务排序类
 * Comparator
 * 改变数据 发现排序没有变化 因为TreeSet是在添加时排序的
 * TreeSet在使用时不能修改数据，否则可能重复，可用final修饰Person里的数据
 */
import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		Person p1 = new Person("您",100);
		Person p2 = new Person("刘德华",1000);
		Person p3 = new Person("梁朝伟",1200);
		Person p4 = new Person("小明",60);
		
		//依次存放到TreeSet容器中，使用排序的业务类(匿名内部类)
		TreeSet<Person> persons = new TreeSet<Person>(
					new java.util.Comparator<Person>(){

						@Override
						public int compare(Person o1, Person o2) {
							return -(o1.getHandsome()-o2.getHandsome());
						}
						
					}
		);
		
		//TreeSet在添加数据时排序，添加p2时就和p1比较
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		System.out.println(persons);
		
		//改变数据 发现排序没有变化 因为TreeSet是在添加时排序的
//		
//		p3.setHandsome(-100);
//		System.out.println(persons);
		
		//改变数据导致内容重复
//		p4.setHandsome(100);
//		p4.setName("您");
//		System.out.println(persons);
	}
}
