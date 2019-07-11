package core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ColumnInfo;
import bean.TableInfo;
import persistentObject.Emp;
import utils.JDBCUtils;
import utils.ReflectUtils;
import vo.EmpVO;

/**
 * 负责针对postgreSQL数据库的查询
 * 
 * @author yinyiliang
 *
 */
public class PostgresqlQuery implements Query {

	public static void main(String[] args) {
//		Number obj = (Number)new PostgresqlQuery().queryValue("select count(*) from emp where salary>?", new Object[] {1000});
		
		//Numbe是Integer,Double,Float...的父类，以后具体需要时可以转型
		Number obj = new PostgresqlQuery().queryNumber("select count(*) from emp where salary>?", new Object[] {1000});
		
		
		System.out.println(obj);
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
	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConn();
		int count = 0;// 计算数据返回的个数（受影响的数据行数）

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);

			//			//给sql设参，原来的问号?被setObject成params[i]
			//			if(params!=null) {
			//				for(int i=0;i<params.length;i++) {
			//					ps.setObject(1+i, params[i]);
			//				}
			//			}

			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
		return 0;
	}

	@Override
	public void insert(Object obj) {
		// obj-->表中 insert into 表名(id,uname,pwd) values (?,?,?)
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);

		List<Object> params = new ArrayList<Object>();// 存储sql的参数对象

		StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
		int countNotNullField = 0;// 计算不为null的属性值

		Field[] fs = c.getDeclaredFields();
		for (Field f : fs) {
			String fieldName = f.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);

			if (fieldValue != null) {
				countNotNullField++;
				sql.append(fieldName + ",");
				params.add(fieldValue);
			}
		}

		// 最后一个逗号换成小括号
		sql.setCharAt(sql.length() - 1, ')');

		sql.append(" values (");

		for (int i = 0; i < countNotNullField; i++) {
			sql.append("?,");
		}

		sql.setCharAt(sql.length() - 1, ')');

		executeDML(sql.toString(), params.toArray());
	}

	@Override
	public void delete(Class clazz, Object id) {
		// Emp.class, 2 --> delete from emp where id=2

		// 通过Class对象找TableInfo 名称可能会有大小写的问题 所以用TableContext里的Map<Class,TableInfo>
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);

		// 获得主键
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + "=? ";

		executeDML(sql, new Object[] { id });

		/*
		 * 
		 * Object[] objs = new Object[]{3,4}; is the same as:
		 * 
		 * Object[] objs = new Object[2]; objs[0] = 3; objs[1] = 4;
		 */
	}

	@Override
	public void delete(Object obj) {
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();// 主键

		// 通过反射机制，调用属性对应的get方法或set方法
		//		try {
		//			Method m = c.getMethod("get"+StringUtils.firstChar2UpperCase(onlyPriKey.getName()), null);
		//			Object priKeyValue = m.invoke(obj, null);
		//			
		//			delete(c, priKeyValue);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c, priKeyValue);
	}

	@Override
	public int update(Object obj, String[] fieldNames) {
		// obj{"uname","pwd"} --> update 表名 set uname=?, pwd=? where id=?
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo priKey = tableInfo.getOnlyPriKey();// 获得唯一主键，目前只能处理唯一主键

		List<Object> params = new ArrayList<Object>();// 存储sql的参数对象

		StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");

		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			sql.append(fname + "=?,");
			params.add(fvalue);
		}
		sql.setCharAt(sql.length() - 1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName() + "=? ");

		params.add(ReflectUtils.invokeGet(priKey.getName(), obj));

		return executeDML(sql.toString(), params.toArray());
	}

	//多行多列
	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {

		Connection conn = DBManager.getConn();
		List list = null;
		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);

			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);

			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();

			// 多行
			while (rs.next()) {
				if(list==null) {
					list = new ArrayList();
				}

				// 调用javabean的无参构造器
				Object rowObj = clazz.newInstance();

				// 多列 select username 'uname', pwd, age from user where id>? and age>18
				for (int i = 0; i < metaData.getColumnCount(); i++) {

					// 用label不用name是因为有可能sql中给列起别名，如'uname'
					// JDBC中计数从1开始
					String columnName = metaData.getColumnLabel(i + 1);// username
					Object columnValue = rs.getObject(i + 1);

					//					//调用rowObj对象的setUsername(String uname)的方法，把columnValue的值设置进去
					//					Method m = clazz.getDeclaredMethod("set"+StringUtils.firstChar2UpperCase(columnName), 
					//								columnValue.getClass());
					//					m.invoke(rowObj, columnValue);
					ReflectUtils.invokeSet(rowObj, columnName, columnValue);
				}

				list.add(rowObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
		return list;
	}

	//一行多列
	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql,clazz,params);

		return (list==null||list.size()==0) ? null : list.get(0);
	}

	//一行一列
	@Override
	public Object queryValue(String sql, Object[] params) {


		Connection conn = DBManager.getConn();
		Object value = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);

			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				//select count(*) from user
				value = rs.getObject(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
		return value;
	}

	
	//查询数字,转化成数字,也可以加上queryDate,queryString字
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}

}
