package test01Student;

public class test02oop {
	public static void main(String[] args){
		Student s1 = new Student();
		s1.name = "С��";
		s1.id = 2;
		
		Computer c1 = new Computer();
		c1.brand = "����";
		c1.cpuSpeed = 100;
		
		s1.computer = c1;
		
		c1.brand = "����";
		//s1.computer.brandҲ���ɡ�����������ΪS1��computer.brand��c1.brandָ��ͬһ��ֵ
		
		System.out.println(s1.computer.brand);		
		
	}
}
