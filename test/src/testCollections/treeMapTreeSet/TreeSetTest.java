package testCollections.treeMapTreeSet;
/**
 * �ṩ�˽���ķ�ʽ��ҵ��������
 * Comparator
 * �ı����� ��������û�б仯 ��ΪTreeSet�������ʱ�����
 * TreeSet��ʹ��ʱ�����޸����ݣ���������ظ�������final����Person�������
 */
import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		Person p1 = new Person("��",100);
		Person p2 = new Person("���»�",1000);
		Person p3 = new Person("����ΰ",1200);
		Person p4 = new Person("С��",60);
		
		//���δ�ŵ�TreeSet�����У�ʹ�������ҵ����(�����ڲ���)
		TreeSet<Person> persons = new TreeSet<Person>(
					new java.util.Comparator<Person>(){

						@Override
						public int compare(Person o1, Person o2) {
							return -(o1.getHandsome()-o2.getHandsome());
						}
						
					}
		);
		
		//TreeSet���������ʱ�������p2ʱ�ͺ�p1�Ƚ�
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		System.out.println(persons);
		
		//�ı����� ��������û�б仯 ��ΪTreeSet�������ʱ�����
//		
//		p3.setHandsome(-100);
//		System.out.println(persons);
		
		//�ı����ݵ��������ظ�
//		p4.setHandsome(100);
//		p4.setName("��");
//		System.out.println(persons);
	}
}
