package testCommons;
/**
 * 员工类
 * 
 * @author yinyiliang
 *
 */
public class Employee {

	private String name;
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
	
	@Override
	public String toString() {
		return "名字: "+this.name+", 收入: "+this.salary;
	}
	
	
}
