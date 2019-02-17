package test01Student;

public class test02oop {
	public static void main(String[] args){
		Student s1 = new Student();
		s1.name = "小光";
		s1.id = 2;
		
		Computer c1 = new Computer();
		c1.brand = "联想";
		c1.cpuSpeed = 100;
		
		s1.computer = c1;
		
		c1.brand = "戴尔";
		//s1.computer.brand也会变成“戴尔”，因为S1。computer.brand和c1.brand指向同一个值
		
		System.out.println(s1.computer.brand);		
		
	}
}
