package otherIO;

/**
 * �սӿ�java.io.Serializable 
 * ֻ�Ǳ�ʶ�ö���������л�
 * 
 * @author yinyiliang
 *
 */
public class Employee implements java.io.Serializable {

	private transient String name;//��transient��ʾ�������л�
	private double salary;
	
	
	public Employee() {

	}


	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
}
