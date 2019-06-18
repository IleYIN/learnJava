package memento;
/**
 * originator
 * 
 * @author y.yin
 *
 */
public class Employer {
	
	private String ename;
	private int age;
	private double salary;
	
	public Employer(String ename, int age, double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
	}
	
	
	//do memento and return memento
	public EmpMemento memento() {
		return new EmpMemento(this);
	}
	
	//recover to the memento
	public void recovery(EmpMemento mmt) {
		this.ename = mmt.getEname();
		this.age = mmt.getAge();
		this.salary = mmt.getSalary();
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
