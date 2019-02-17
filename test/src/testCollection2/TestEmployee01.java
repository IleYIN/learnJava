package testCollection2;

/**
 * 通过list来存储数据
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestEmployee01 {
	
	public static void main(String[] args) throws Exception {
//		Employee e = new Employee();
//		e.setId(0301);
//		e.setName("高琪");
//		e.setDepartment("项目部");
//		e.setSalary(3000);
//		String strDate = "2007-10";
//		DateFormat format = new SimpleDateFormat("yyyy-MM");//转换时间对象格式
//		e.setHireDate(format.parse(strDate));
		
		//下面一个对象对应了一行记录，一个Employee类代表了一个表结构
		Employee e = new Employee(0301,"高琪",3000,"项目部","2007-10");		
		Employee e2 = new Employee(0302,"马士兵",3500,"教学部","2006-10");		
		Employee e3 = new Employee(0303,"裴新",3540,"教学部","2007-10");		
		
		//加了泛型表示这个容器里只能放Employee了，别的放不了
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		list.add(e3);
		
		printEmpName(list);
	}
	
	public static void printEmpName(List<Employee> list){
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i).getName());
		}
	}
}
