package core;

/**
 * ����Query����Ĺ����� 
 * @author yinyiliang
 *
 */
public class QueryFactory {
	
//	private static QueryFactory factory = new QueryFactory();����ģʽ�Ĺ���
//	private static Class c;��
	private static Query prototypeObj;
	
	static {
		
		
		
		
		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());//����ָ����query��,����DBManager��ɳ�ʼ��
//			c.newInstance();
			prototypeObj = (Query) c.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private QueryFactory() {
		//˽�й�����
	}
	
	
	public static Query createQuery() {
//		return new PostgresqlQuery();
		
//		try {
////			return (Query)c.newInstance();//���ܻή��Ч�ʣ����ÿ�¡ģʽ
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			return (Query) prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
