package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ��װ�˷���ĳ��ò���
 */
public class ReflectUtils {
	
	
	/**
	 * ����obj����Ķ�Ӧ���Ե�fieldName��get����
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		
		//ͨ��������ƣ��������Զ�Ӧ��get������set����
		try {
			Method m = obj.getClass().getDeclaredMethod("get"+StringUtils.firstChar2UpperCase(fieldName), null);
			return m.invoke(obj, null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void invokeSet(Object obj, String columnName, Object columnValue) {
		try {
			//����rowObj�����setUsername(String uname)�ķ�������columnValue��ֵ���ý�ȥ
			Method m = obj.getClass().getDeclaredMethod("set"+StringUtils.firstChar2UpperCase(columnName), 
					columnValue.getClass());
			m.invoke(obj, columnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
