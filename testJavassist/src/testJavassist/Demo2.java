package testJavassist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * 测试javassist的API
 * 
 * @author yinyiliang
 *
 */
public class Demo2 {

	/**
	 * 处理类的基本方法
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IOException 
	 */
	public static void test01() throws NotFoundException, IOException, CannotCompileException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("testJavassist.Emp");
		
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		
		System.out.println(cc.getName());//获取类名
		System.out.println(cc.getSimpleName());//获取简要类名
		System.out.println(cc.getSuperclass());//获得父类
		System.out.println(cc.getInterfaces());//获得接口
		
		cc.defrost();//解冻
		
	}
	
	/**
	 * 测试产生新的方法
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void test02() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("testJavassist.Emp");
		
		//CtMethod m = CtNewMethod.make("public int add(inta, intb) {return a+b;}", cc);
		//或以下方法
		CtMethod m = new CtMethod(CtClass.intType,"add",
				new CtClass[] {CtClass.intType,CtClass.intType}, cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"hello\"); return $1+$2;}");//$0指this，$1，$2指实际参数
		
		cc.addMethod(m);
		
		
		//通过反射调用新生成的方法
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp文件
		Method method = clazz.getDeclaredMethod("add", int.class,int.class);
		Object result = method.invoke(obj, 200, 300);
		System.out.println(result);
		
		cc.defrost();//解冻
	}
	
	
	
	/**
	 * 修改已有的方法信息
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void test03() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("testJavassist.Emp");
		
		//获取已经存在的方法
		CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[] {CtClass.intType});
		
		//修改已经存在的方法
		cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
		cm.insertAt(32, "int b = 3; System.out.println(\"b=\"+b);");
		cm.insertAfter("System.out.println(\"end!!!\");");
		
		
		//通过反射调用方法
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp文件
		Method method = clazz.getDeclaredMethod("sayHello", int.class);
		Object result = method.invoke(obj, 300);
		//System.out.println(result);//返回值没有，是null
		
		cc.defrost();//解冻
	}
	
	/**
	 * 修改属性
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void test04() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("testJavassist.Emp");
	
//		CtField f1 = CtField.make("private int empno", cc);
		CtField f1 = new CtField(CtClass.intType,"salary",cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1, "1000");//不需要传递值时，就写cc.addField("1000");
	
//		cc.getDeclaredField("ename");//获取指定的属性
		
		//创建set get 方法
//		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}",cc);
		cc.addMethod(CtNewMethod.getter("getsalary", f1));
		cc.addMethod(CtNewMethod.setter("setsalary", f1));
		
	}
	
	/**
	 * 构造方法的操作
	 * @throws NotFoundException
	 */
	public static void test05() throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("testJavassist.Emp");
		
		CtConstructor[] cs = cc.getConstructors();
		for (CtConstructor c : cs) {
			System.out.println(c.getLongName());//获得构造器的方法标记
		}
	}
	
	public static void test06() throws NotFoundException, ClassNotFoundException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("testJavassist.Emp");
		
		Object[] all = cc.getAnnotations();
		Author a = (Author)all[0];
		String name = a.name();
		int year = a.year();
		
		System.out.println("name:"+name+" year:"+year);
	}
	
	
	
	/**
	 * 
	 * @param args
	 * @throws NotFoundException
	 * @throws IOException
	 * @throws CannotCompileException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	
	public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		//test01();
		//test02();
		test06();
	}
}
