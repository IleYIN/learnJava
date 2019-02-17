package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试使用Map来封装一条记录
 * 	List<Map> 封装多条记录
 * 
 * @author yinyiliang
 * 
 *
 */


public class Demo01{

	//存一条
	public static void test01() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,Object> row = new HashMap<String,Object>();//使用一个Map封装一条记录

		try {
			conn = JDBCUtil.getPostgreConn();
			ps = conn.prepareStatement("select empname, salary, age from emp where id > ?");
			ps.setObject(1,0);
			rs = ps.executeQuery();

			while(rs.next()) {
				//				System.out.println(rs.getString(1));
				row.put("empname",rs.getObject(1));
				row.put("salary",rs.getObject(2));
				row.put("age",rs.getObject(3));
			}

		} catch (Exception e) {
			e.printStackTrace();


		} finally {

			JDBCUtil.close(rs, ps, conn);
		}


		//遍历Map
		for(String key:row.keySet()) {

			System.out.print(key+"--"+row.get(key)+"\t");
		}
	}

	//存多条

	public static void test02() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,Object> > list = new ArrayList<Map<String,Object>>();

		try {
			conn = JDBCUtil.getPostgreConn();
			ps = conn.prepareStatement("select empname, salary, age from emp where id > ?");
			ps.setObject(1,0);
			rs = ps.executeQuery();

			while(rs.next()) {
				//				System.out.println(rs.getString(1));
				Map<String,Object> row = new HashMap<String,Object>();//使用一个Map封装一条记录

				row.put("empname",rs.getObject(1));
				row.put("salary",rs.getObject(2));
				row.put("age",rs.getObject(3));

				list.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();


		} finally {

			JDBCUtil.close(rs, ps, conn);
		}

		for (Map<String,Object> row : list) {

			//遍历Map
			for(String key:row.keySet()) {

				System.out.print(key+"--"+row.get(key)+"\t");
			}
			System.out.println();
		}
	}


	public static void test03() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,Map<String,Object>> maps = new HashMap<String,Map<String,Object>>();

		try {
			conn = JDBCUtil.getPostgreConn();
			ps = conn.prepareStatement("select empname, salary, age from emp where id > ?");
			ps.setObject(1,0);
			rs = ps.executeQuery();

			while(rs.next()) {
				//				System.out.println(rs.getString(1));
				Map<String,Object> row = new HashMap<String,Object>();//使用一个Map封装一条记录

				row.put("empname",rs.getObject(1));
				row.put("salary",rs.getObject(2));
				row.put("age",rs.getObject(3));

				maps.put(rs.getString(1), row);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			JDBCUtil.close(rs, ps, conn);
		}


		for(String empname:maps.keySet()) {

			//遍历Map
			for(String key:maps.get(empname).keySet()) {

				System.out.print(key+"--"+maps.get(empname).get(key)+"\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)  {
		test03();
	}

}
