package testjavabean;
/**
 * javabean：空构造器一定要有，还有set get方法
 */
import java.sql.Date;

public class Emp {//表结构和类对应
	private Integer id;
	private String empname;
	private Float salary;
	private Date birhday;
	private Integer age;
	

	private Integer deptId;
	
	public Emp() {
	}
	
	

	public Emp(String empname, Float salary, Integer age) {
		super();
		this.empname = empname;
		this.salary = salary;
		this.age = age;
	}





	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Date getBirhday() {
		return birhday;
	}
	public void setBirhday(Date birhday) {
		this.birhday = birhday;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	
	

}
