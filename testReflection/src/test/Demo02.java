package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（类的名字、属性、方法、构造器等）
 * @author yinyiliang
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		String path = "test.bean.User";
		
		try {
			Class clazz = Class.forName(path);
			
			//获取类的名字
			System.out.println(clazz.getName());
			System.out.println(clazz.getSimpleName());
			
			//获取属性信息
//			Field[] fields = clazz.getFields();//只能获取public的field
			Field[] fields = clazz.getDeclaredFields();//获得所有fields
			Field f = clazz.getDeclaredField("uname");
			
			System.out.println(f);
			System.out.println(fields.length);
			for(Field temp:fields) {
				System.out.println("属性："+temp);
			}
			
			//获取方法信息
			Method[] methods = clazz.getDeclaredMethods();
			Method m = clazz.getDeclaredMethod("getUname", null);
			Method m2 = clazz.getDeclaredMethod("setUname", String.class);//有参数的把参数的Class写上以区分重载
			
			for(Method temp:methods) {
				System.out.println("方法："+temp);
			}
			
			//获取构造器信息
			Constructor[] cons = clazz.getDeclaredConstructors();
			for(Constructor temp:cons) {
				System.out.println("构造器："+temp);
			}
			
			Constructor c = clazz.getDeclaredConstructor(null);
			System.out.println(c);
			c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}