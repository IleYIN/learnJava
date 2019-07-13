package core;

/**
 * 创建Query对象的工厂类 
 * @author yinyiliang
 *
 */
public class QueryFactory {
	
//	private static QueryFactory factory = new QueryFactory();单例模式的工厂
//	private static Class c;、
	private static Query prototypeObj;
	
	static {
		
		
		
		
		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());//加载指定的query类,调用DBManager完成初始化
//			c.newInstance();
			prototypeObj = (Query) c.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private QueryFactory() {
		//私有构造器
	}
	
	
	public static Query createQuery() {
//		return new PostgresqlQuery();
		
//		try {
////			return (Query)c.newInstance();//可能会降低效率，改用克隆模式
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
