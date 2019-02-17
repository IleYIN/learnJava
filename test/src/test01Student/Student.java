package test01Student;

public class Student {
	
	//静态的数据
	String name;
	int id;
	Computer computer;
	//动态的行为
	public void study() {
		System.out.println("id是"+id+"的"+name+"在学习");
	}
	public void sayHello(String sname){
		System.out.println(name+"向"+sname+"说你好");
	}
}
