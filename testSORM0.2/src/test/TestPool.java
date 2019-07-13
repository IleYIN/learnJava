package test;

import java.util.List;

import core.Query;
import core.QueryFactory;
import vo.EmpVO;

/**
 * �������ӳص�Ч��
 * @author yinyiliang
 *
 */
public class TestPool {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		for(int i=0; i<30; i++) {
			test01();
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a);//�������ӳ�Ҫ3000s�������ӳ�Ҫ900����
	}
	
	public static void test01() {
		Query q = QueryFactory.createQuery();
		String sql2 = "select e.id, empname, salary+bonus totSalary, age, d.dname deptName, d.address deptAddr from emp e join dept d on e.deptid=d.id;";
		List<EmpVO> list2 =  q.queryRows(sql2, EmpVO.class, null);

		for(EmpVO e:list2) {

			System.out.println(e.getEmpname()+"-"+e.getDeptaddr()+"-"+e.getTotsalary());
		}
	}
}
