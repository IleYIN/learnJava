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
 * �����ѯ�������ṩ����ĺ����ࣩ
 * 
 * @author yinyiliang
 *
 */

/**
 * 
DML��data manipulation language����
       ������SELECT��UPDATE��INSERT��DELETE��������������һ������4�����������������ݿ�������ݽ��в���������
DDL��data definition language����
       DDL��DMLҪ�࣬��Ҫ��������CREATE��ALTER��DROP�ȣ�DDL��Ҫ�����ڶ����ı��TABLE���Ľṹ���������ͣ���֮������Ӻ�Լ���ȳ�ʼ�������ϣ����Ǵ���ڽ�����ʱʹ��
DCL��Data Control Language����
       �����ݿ���ƹ��ܡ����������û�������ݿ��û����ɫȨ�޵���䣬������grant,deny,revoke�ȣ���䡣��Ĭ��״̬�£�ֻ��sysadmin,dbcreator,db_owner��db_securityadmin����Ա����Ȩ��ִ��DCL
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
	 * Ϊ���Ӳ�ѯ�ṩģ��  ģ�巽��ģʽ��JDBC������װ��ģ��������� �Ż�����
	 * @param sql sql���
	 * @param params sql�Ĳ���
	 * @param clazz ��¼Ҫ��װ����java��
	 * @param cb  CallBack��ʵ���࣬ʵ�ֻص�
	 * @return ��ѯ���
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
	 * ֱ��ִ��һ��DML���
	 * @param sql
	 * @param params
	 * @return ִ��sql����Ӱ���¼������
	 */
	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConn();
		int count = 0;// �������ݷ��صĸ�������Ӱ�������������

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);

			//			//��sql��Σ�ԭ�����ʺ�?��setObject��params[i]
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
	 * ��һ������洢�����ݿ���
	 * ���������Բ�λnull�����Դ洢��������null����Ϊ0
	 * @param obj
	 */
	public void insert(Object obj) {
		// obj-->���� insert into ����(id,uname,pwd) values (?,?,?)
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);

		List<Object> params = new ArrayList<Object>();// �洢sql�Ĳ�������

		StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
		int countNotNullField = 0;// ���㲻Ϊnull������ֵ

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

		// ���һ�����Ż���С����
		sql.setCharAt(sql.length() - 1, ')');

		sql.append(" values (");

		for (int i = 0; i < countNotNullField; i++) {
			sql.append("?,");
		}

		sql.setCharAt(sql.length() - 1, ')');

		executeDML(sql.toString(), params.toArray());
	}

	/**
	 * ɾ��clazz��ʾ���Ӧ�ı��еļ�¼��ָ������ֵid�ļ�¼��
	 * @param clazz ���ݱ��Ӧ�����Class����
	 * @param id ������ֵ
	 */
	public void delete(Class clazz, Object id) {
		// Emp.class, 2 --> delete from emp where id=2

		// ͨ��Class������TableInfo ���ƿ��ܻ��д�Сд������ ������TableContext���Map<Class,TableInfo>
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);

		// �������
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
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼���������ڵ����Ӧ���������������ֵ��Ӧ����¼��
	 * @param obj
	 */
	public void delete(Object obj) {
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();// ����

		// ͨ��������ƣ��������Զ�Ӧ��get������set����
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
	 * ���¶����Ӧ�ļ�¼������ֻ����ָ�����ֶε�ֵ
	 * @param obj ��Ҫ���µĶ���
	 * @param fieldNames ���µ������б�
	 * @return ִ��sql����Ӱ���¼������
	 */
	public int update(Object obj, String[] fieldNames) {
		// obj{"uname","pwd"} --> update ���� set uname=?, pwd=? where id=?
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo priKey = tableInfo.getOnlyPriKey();// ���Ψһ������Ŀǰֻ�ܴ���Ψһ����

		List<Object> params = new ArrayList<Object>();// �洢sql�Ĳ�������

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
	 * ��ѯ���ض��м�¼������ÿ����¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean��Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public List queryRows(final String sql, final Class clazz, final Object[] params) {
		//�����ڲ���������ĳ��� ���Լ�final
		
		return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {

			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {

				List list = null;
				try {
					ResultSetMetaData metaData = rs.getMetaData();
					// ����
					while (rs.next()) {
						if(list==null) {
							list = new ArrayList();
						}
						// ����javabean���޲ι�����
						Object rowObj = clazz.newInstance();

						// ���� select username 'uname', pwd, age from user where id>? and age>18
						for (int i = 0; i < metaData.getColumnCount(); i++) {

							// ��label����name����Ϊ�п���sql�и������������'uname'
							// JDBC�м�����1��ʼ
							String columnName = metaData.getColumnLabel(i + 1);// username
							Object columnValue = rs.getObject(i + 1);

							// ����rowObj�����setUsername(String uname)�ķ�������columnValue��ֵ���ý�ȥ
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
	 * ��ѯ����һ�м�¼�������ü�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql,clazz,params);

		return (list==null||list.size()==0) ? null : list.get(0);
	}

	/**
	 * ����������ֱֵ�Ӳ��Ҷ�Ӧ�Ķ���
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
	 * ��ѯ����һ��ֵ��һ��һ�У���������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
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
	 * ��ѯ����һ�����֣�һ��һ�У���������ֵ����
	 * ��ѯ����,ת��������,Ҳ���Լ���queryDate,queryString��
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ��������
	 */

	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNum �ڼ�ҳ����
	 * @param size ÿҳ��ʾ���ټ�¼
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum, int size);

}
