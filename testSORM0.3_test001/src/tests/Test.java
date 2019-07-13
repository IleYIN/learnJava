package tests;


import java.util.List;

import core.Query;
import core.QueryFactory;
import core.TableContext;
import test.po.Emp;
import test.vo.EmpVO;

public class Test {
	
	public static void main(String[] args) {
		//通过这个方法生成po类
		TableContext.updateJavaPOFile();
		
//		select04();
		test05();
//		delete();
//		update();
	}
	
	public static void select01() {
		Query q = QueryFactory.createQuery();
		Number n = q.queryNumber("select count(*) from emp where salary>?", new Object[] {500} );
		
		System.out.println(n);
	}
	
	public static void select02() {
		Query q = QueryFactory.createQuery();
		Emp e = (Emp)q.queryUniqueRow("select * from emp where id=?", Emp.class, new Object[] {2});
		System.out.println(e.getEmpname());
	}
	
	public static void select03() {
		Query q = QueryFactory.createQuery();
		List<Emp> list = (List)q.queryRows("select * from emp where salary>?", Emp.class, new Object[] {1000});
		System.out.println(list);
		for(Emp emp:list) {
			System.out.println(emp.getEmpname());
		}
	}
	
	public static void select04() {
		Query q = QueryFactory.createQuery();
		String sql = "select e.id, empname, salary+bonus totSalary, age, d.dname deptName, d.address deptAddr from emp e join dept d on e.deptid=d.id";
		List<EmpVO> list = (List)q.queryRows(sql, EmpVO.class, null);
		System.out.println(list);
		for(EmpVO emp:list) {
			System.out.println(emp.getEmpname()+"--"+emp.getTotsalary()+"--"+emp.getDeptname()+"--"+emp.getDeptaddr());
		}
	}
	
	public static void test05() {
		Query q = QueryFactory.createQuery();
		Emp e = (Emp) q.queryById(Emp.class, 5);
		System.out.println(e.getEmpname());
	}
	
	public static void add() {
		Emp e = new Emp();
		e.setId(6);
		e.setAge(18);
		e.setEmpname("YYL");
		e.setSalary(2000.0F);
		
		Query q = QueryFactory.createQuery();
		q.insert(e);
	}

	public static void delete() {
		Emp e = new Emp();
		e.setId(6);
		
		Query q = QueryFactory.createQuery();
		q.delete(e);
	}
	
	public static void update() {
		Emp e = new Emp();
		e.setId(10);
		e.setAge(18);
		e.setSalary(200.0F);
		
		Query q = QueryFactory.createQuery();
		q.update(e, new String[] {"age","salary"});
	}
	
	
}
