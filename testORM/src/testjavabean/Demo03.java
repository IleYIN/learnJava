package testjavabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.JDBCUtil;

/**
 * 测试Javabean使用来封装一条记录
 * 	List<Javabean> 封装多条记录
 * 
 * @author yinyiliang
 * 
 *
 */


public class Demo03{


	//存一条
	public static void test01() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		
		try {
			conn = JDBCUtil.getPostgreConn();
			ps = conn.prepareStatement("select empname, salary, age from emp where id > ?");
			ps.setObject(1,0);
			rs = ps.executeQuery();

			while(rs.next()) {
				//				System.out.println(rs.getString(1));
				emp = new Emp(rs.getString(1),rs.getFloat(2),rs.getInt(3));
			}

		} catch (Exception e) {
			e.printStackTrace();


		} finally {

			JDBCUtil.close(rs, ps, conn);
		}
		
		System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());

	}

	//存多条

	public static void test02() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<Emp>();

		try {
			conn = JDBCUtil.getPostgreConn();
			ps = conn.prepareStatement("select empname, salary, age from emp where id > ?");
			ps.setObject(1,0);
			rs = ps.executeQuery();

			while(rs.next()) {
				//				System.out.println(rs.getString(1));
				Emp emp = new Emp(rs.getString(1),rs.getFloat(2),rs.getInt(3));
				list.add(emp);
			}

		} catch (Exception e) {
			e.printStackTrace();


		} finally {

			JDBCUtil.close(rs, ps, conn);
		}

		for ( Emp emp : list) {
			System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());
		}
	}


	
	public static void main(String[] args)  {
		test02();
	}
}
