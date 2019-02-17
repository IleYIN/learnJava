package testCollections.treeMapTreeSet;

public class Worker implements java.lang.Comparable<Worker>{

	private String type;
	private double salary;
	
	public Worker() {

	}

	public Worker(String type, double salary) {
		super();
		this.type = type;
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override//按工资升序
	public int compareTo(Worker o) {
		return this.salary>o.salary?1:this.salary==o.salary?0:-1;
	}
	
	@Override
	public String toString() {
		return "类型："+this.type+",收入："+this.salary+"\n";
	}
	
	
	
}
