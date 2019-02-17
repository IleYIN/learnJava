package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����ʹ��Map����װһ����¼
 * 	List<Map> ��װ������¼
 * 
 * @author yinyiliang
 * 
 *
 */


public class Demo01{

	//��һ��
	public static void test01() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,Object> row = new HashMap<String,Object>();//ʹ��һ��Map��װһ����¼

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


		//����Map
		for(String key:row.keySet()) {

			System.out.print(key+"--"+row.get(key)+"\t");
		}
	}

	//�����

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
				Map<String,Object> row = new HashMap<String,Object>();//ʹ��һ��Map��װһ����¼

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

			//����Map
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
				Map<String,Object> row = new HashMap<String,Object>();//ʹ��һ��Map��װһ����¼

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

			//����Map
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
