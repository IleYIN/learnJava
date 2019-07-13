package core;

import java.util.List;

import persistentObject.Emp;
import vo.EmpVO;

/**
 * �������postgreSQL���ݿ�Ĳ�ѯ
 * 
 * @author yinyiliang
 *
 */
public class PostgresqlQuery extends Query {

	public static void main(String[] args) {
//		Number obj = (Number)new PostgresqlQuery().queryValue("select count(*) from emp where salary>?", new Object[] {1000});
		
		//Numbe��Integer,Double,Float...�ĸ��࣬�Ժ������Ҫʱ����ת��
		Number obj = new PostgresqlQuery().queryNumber("select count(*) from emp where salary>?", new Object[] {1000});
		System.out.println(obj);
		
		
		//����executeQueryTemplate
//		testQueryRows();
		
	}


	public static void testQueryRows() {

		//		List<Emp> list = new PostgresqlQuery()
		//			.queryRows("select id, empname, age from emp where age>"
		//					+ "? and salary<?",
		//					Emp.class, new Object[] {10,4000});//age>10, salary<5000
		//
		//		for(Emp e:list) {
		//			
		//			System.out.println(e.getEmpname());
		//		}

		String sql2 = "select e.id, empname, salary+bonus totSalary, age, d.dname deptName, d.address deptAddr from emp e join dept d on e.deptid=d.id;";
		List<EmpVO> list2 = new PostgresqlQuery().queryRows(sql2, EmpVO.class, null);

		for(EmpVO e:list2) {

			System.out.println(e.getEmpname()+"-"+e.getDeptaddr()+"-"+e.getTotsalary());
		}

	}

	public static void testDML() {

		Emp e = new Emp();
		e.setId(10);
		e.setEmpname("pear");
		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
		e.setBonus(100.5F);
		e.setSalary(55F);
		e.setAge(0);

		//		new PostgresqlQuery().delete(e);
		//		new PostgresqlQuery().insert(e);

		new PostgresqlQuery().update(e, new String[] { "empname", "salary", "bonus", "age" });
	}


	@Override
	public Object queryPagenate(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
