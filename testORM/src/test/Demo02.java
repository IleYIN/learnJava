package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用Object[]来封装一条记录
 * 	List<Object[]> 封装多条记录
 * 
 * @author yinyiliang
 * 
 *
 */


public class Demo02{

	public static void main(String[] args)  {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		Object[] objs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		
		try {
			conn = JDBCUtil.getPostgreConn();
			ps = conn.prepareStatement("select empname, salary, age from emp where id > ?");
			ps.setObject(1,0);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Object[] objs = new Object[3];//一个Object数组封装了一条记录的信息
//				System.out.println(rs.getString(1));
				objs[0] = rs.getObject(1);
				objs[1] = rs.getObject(2);
				objs[2] = rs.getObject(3);
				
				list.add(objs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
		} finally {

			JDBCUtil.close(rs, ps, conn);
		}
		
		for(Object[] objs:list) {
			
			System.out.println(""+objs[0]+objs[1]+objs[2]);
		}
	}
}
