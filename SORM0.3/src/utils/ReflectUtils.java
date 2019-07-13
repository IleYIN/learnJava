package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 封装了反射的常用操作
 */
public class ReflectUtils {
	
	
	/**
	 * 调用obj对象的对应属性的fieldName的get方法
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		
		//通过反射机制，调用属性对应的get方法或set方法
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
			//调用rowObj对象的setUsername(String uname)的方法，把columnValue的值设置进去
			Method m = obj.getClass().getDeclaredMethod("set"+StringUtils.firstChar2UpperCase(columnName), 
					columnValue.getClass());
			m.invoke(obj, columnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
