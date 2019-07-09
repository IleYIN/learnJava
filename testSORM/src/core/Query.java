package core;

import java.util.List;

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
public interface Query {

	
	/**
	 * ֱ��ִ��һ��DML���
	 * @param sql
	 * @param params
	 * @return ִ��sql����Ӱ���¼������
	 */
	public int executeDML(String sql, Object[] params);
	
	
	/**
	 * ��һ������洢�����ݿ���
	 * @param obj
	 */
	public void insert(Object obj);
	
	
	/**
	 * ɾ��clazz��ʾ���Ӧ�ı��еļ�¼��ָ������ֵid�ļ�¼��
	 * @param clazz ���ݱ��Ӧ�����Class����
	 * @param id ������ֵ
	 */
	public void delete(Class clazz, int id);//delete from User where id=2;
	
	
	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼���������ڵ����Ӧ���������������ֵ��Ӧ����¼��
	 * @param obj
	 */
	public void delete(Object obj);
	
	
	/**
	 * ���¶����Ӧ�ļ�¼������ֻ����ָ�����ֶε�ֵ
	 * @param obj ��Ҫ���µĶ���
	 * @param fieldNames ���µ������б�
	 * @return ִ��sql����Ӱ���¼������
	 */
	public int update(Object obj, String[] fieldNames); //update user set uname=?,pwd=?
	
	
	/**
	 * ��ѯ���ض��м�¼������ÿ����¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean��Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public List queryRows(String sql, Class clazz, Object[] params);
	
	/**
	 * ��ѯ����һ�м�¼�������ü�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql, Class clazz, Object[] params);
	
	
	/**
	 * ��ѯ����һ��ֵ��һ��һ�У���������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql, Object[] params);
	
	
	/**
	 * ��ѯ����һ�����֣�һ��һ�У���������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ��������
	 */
	public Number queryNumber(String sql, Object[] params);
	
	
}
