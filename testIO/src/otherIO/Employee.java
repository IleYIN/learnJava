package otherIO;

/**
 * 空接口java.io.Serializable 
 * 只是标识该对象可以序列化
 * 
 * @author yinyiliang
 *
 */
public class Employee implements java.io.Serializable {

	private transient String name;//加transient表示不用序列化
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
