package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import test.bean.User;


/**
 * 通过反射API动态的操作：构造器，方法，属性
 * 
 * @author yinyiliang
 *
 */
public class Demo03 {

	public static void main(String[] args) {
	
		String path = "test.bean.User";
		try {
			Class<User> clazz = (Class<User>)Class.forName(path);
			
			//通过动态调用构造方法，构造对象
			User u = clazz.newInstance();//必须有无参构造方法
			System.out.println(u);
			
			Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = c.newInstance(101,18,"名字2");
			System.out.println(u2.getUname());
			
			
			//通过反射API调用普通方法
			User u3 = clazz.newInstance();
			
			//下面两行相当于u3.setUname("名字3");动态调用方法
			Method method = clazz.getDeclaredMethod("setUname",String.class);
			method.invoke(u3, "名字3");
			
			System.out.println(u3.getUname());
			
			
			//通过反射API调用属性
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("uname");
			//f.set(u4, "名字4");//报错，不能访问私有属性
			
			f.setAccessible(true);//表示这个属性不用做安全检查了，可以直接访问
			f.set(u4, "名字4");//通过反射直接写属性
			
			System.out.println(u4.getUname());//方法直接调用
			System.out.println(f.get(u4));//通过反射直接读属性的值
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
