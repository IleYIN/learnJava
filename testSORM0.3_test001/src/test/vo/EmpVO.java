package test.vo;

/**
 * 有复杂对象时可以建一个VO
 * 便于复杂查询
 * @author yinyiliang
 *
 */
public class EmpVO {
	//select e.id, empname, salary+bonus totSalary, age, d.dname deptName, d.address deptAddr from emp e join dept d on e.deptid=d.id;
	private Integer id;
	private String empname;
	private Float totsalary;
	private Integer age;
	private String deptname;
	private String deptaddr;

	public EmpVO() {
	}

	
	
	public EmpVO(Integer id, String empname, Float totsalary, Integer age, String deptname, String deptaddr) {
		super();
		this.id = id;
		this.empname = empname;
		this.totsalary = totsalary;
		this.age = age;
		this.deptname = deptname;
		this.deptaddr = deptaddr;
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

	public Float getTotsalary() {
		return totsalary;
	}

	public void setTotsalary(Float totsalary) {
		this.totsalary = totsalary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptaddr() {
		return deptaddr;
	}

	public void setDeptaddr(String deptaddr) {
		this.deptaddr = deptaddr;
	}

	

}
