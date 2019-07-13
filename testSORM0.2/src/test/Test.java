package test;

import java.util.List;

import core.Query;
import core.QueryFactory;
import vo.EmpVO;


/**
 * 客户端调用测试类
 * @author yinyiliang
 *
 */
public class Test {
	public static void main(String[] args) {
		Query q = QueryFactory.createQuery();
		String sql2 = "select e.id, empname, salary+bonus totSalary, age, d.dname deptName, d.address deptAddr from emp e join dept d on e.deptid=d.id;";
		List<EmpVO> list2 =  q.queryRows(sql2, EmpVO.class, null);

		for(EmpVO e:list2) {

			System.out.println(e.getEmpname()+"-"+e.getDeptaddr()+"-"+e.getTotsalary());
		}

	}
}
