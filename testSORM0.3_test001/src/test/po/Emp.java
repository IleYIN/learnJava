package test.po;

import java.sql.*;
import java.util.*;

public class Emp {

	private String empname;
	private java.sql.Date birthday;
	private Float bonus;
	private Integer deptid;
	private Integer id;
	private Float salary;
	private Integer age;


	public String getEmpname(){
		return empname;
	}
	public java.sql.Date getBirthday(){
		return birthday;
	}
	public Float getBonus(){
		return bonus;
	}
	public Integer getDeptid(){
		return deptid;
	}
	public Integer getId(){
		return id;
	}
	public Float getSalary(){
		return salary;
	}
	public Integer getAge(){
		return age;
	}
	public void setEmpname(String empname){
		this.empname=empname;
	}
	public void setBirthday(java.sql.Date birthday){
		this.birthday=birthday;
	}
	public void setBonus(Float bonus){
		this.bonus=bonus;
	}
	public void setDeptid(Integer deptid){
		this.deptid=deptid;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setSalary(Float salary){
		this.salary=salary;
	}
	public void setAge(Integer age){
		this.age=age;
	}
}
