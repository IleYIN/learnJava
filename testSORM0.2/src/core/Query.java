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
import utils.JDBCUtils;
import utils.ReflectUtils;

/**
 * 负责查询（对外提供服务的核心类）
 * 
 * @author yinyiliang
 *
 */

/**
 * 
DML（data manipulation language）：
       它们是SELECT、UPDATE、INSERT、DELETE，就象它的名字一样，这4条命令是用来对数据库里的数据进行操作的语言
DDL（data definition language）：
       DDL比DML要多，主要的命令有CREATE、ALTER、DROP等，DDL主要是用在定义或改变表（TABLE）的结构，数据类型，表之间的链接和约束等初始化工作上，他们大多在建立表时使用
DCL（Data Control Language）：
       是数据库控制功能。是用来设置或更改数据库用户或角色权限的语句，包括（grant,deny,revoke等）语句。在默认状态下，只有sysadmin,dbcreator,db_owner或db_securityadmin等人员才有权力执行DCL
 * @author yinyiliang
 *
 */


@SuppressWarnings("all")
public abstract class Query implements Cloneable {

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	/**
	 * 为复杂查询提供模板  模板方法模式将JDBC操作封装成模板便于重用 优化代码
	 * @param sql sql语句
	 * @param params sql的参数
	 * @param clazz 记录要封装到的java类
	 * @param cb  CallBack的实现类，实现回调
	 * @return 查询结果
	 */
	public Object executeQueryTemplate(String sql, Object[] params, Class clazz, CallBack cb) {

		Connection conn = DBManager.getConn();
		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);

			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);

			rs = ps.executeQuery();
			
		return cb.doExecute(conn, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(ps, conn);
		}
	}
	
	
	/**
	 * 直接执行一个DML语句
	 * @param sql
	 * @param params
	 * @return 执行sql语句后影响记录的行数
	 */
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
		return count;
	}



	/**
	 * 将一个对象存储到数据库中
	 * 对象中属性部位null的属性存储，数字是null的设为0
	 * @param obj
	 */
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

	/**
	 * 删除clazz表示类对应的表中的记录（指定主键值id的记录）
	 * @param clazz 根据表对应的类的Class对象
	 * @param id 主键的值
	 */
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

	/**
	 * 删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
	 * @param obj
	 */
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


	/**
	 * 更新对象对应的记录，并且只更新指定的字段的值
	 * @param obj 所要更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return 执行sql语句后影响记录的行数
	 */
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

	/**
	 * 查询返回多行记录，并将每条记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public List queryRows(final String sql, final Class clazz, final Object[] params) {
		//匿名内部类用外面的常量 所以加final
		
		return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {

			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {

				List list = null;
				try {
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

							// 调用rowObj对象的setUsername(String uname)的方法，把columnValue的值设置进去
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}

						list.add(rowObj);
					}
				} catch (Exception e) { //Alt + Shift + z
					e.printStackTrace();
				}
				return list;
			}
			
		});

	}

	/**
	 * 查询返回一行记录，并将该记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql,clazz,params);

		return (list==null||list.size()==0) ? null : list.get(0);
	}

	/**
	 * 根据主键的值直接查找对应的对象
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object queryById(Class clazz, Object id) {
		//select * from emp where id=?
		//delete * from emp where id=?
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		
		String sql = "select * from "+tableInfo.getTname()+" where "+onlyPriKey.getName()+"=? ";
		return queryUniqueRow(sql, clazz, new Object[] {id});
	}

	/**
	 * 查询返回一个值（一行一列），并将该值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryValue(String sql, Object[] params) {
		
		return executeQueryTemplate(sql, params, null, new CallBack() {

			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value = null;
				try {
					while (rs.next()) {
						//select count(*) from user
						value = rs.getObject(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return value;
			}
			
		});
		
	}


	/**
	 * 查询返回一个数字（一行一列），并将该值返回
	 * 查询数字,转化成数字,也可以加上queryDate,queryString字
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的数字
	 */

	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}
	
	/**
	 * 分页查询
	 * @param pageNum 第几页数据
	 * @param size 每页显示多少记录
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum, int size);

}
