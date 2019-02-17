package testCollection2;


/**
 * 通过list来存储数据
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {   
	//Javabean,实体类，只有属性和相关的setget方法，逻辑简单的类
	
	private int id;
	private String name;
	private int salary;
	private String department;
//	private Date hireDate;
	private Date hireDate;
	
	
	public Employee(int id, String name, int salary, String department, String hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		
		DateFormat format = new SimpleDateFormat("yyyy-MM");//转换时间对象格式
		try {
			this.hireDate = format.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		DateFormat format = new SimpleDateFormat("yyyy-MM");//转换时间对象格式
		try {
			this.hireDate = format.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
} //类对应表结构ID姓名薪水部门入职时间
	//私有的要增加set和get方法

