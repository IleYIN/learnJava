package testJavassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 测试使用javassit生成一个新的类
 * 
 * @author yinyiliang
 *
 */
public class Demo01 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		//类池
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("bean.Emp");
		
		//创建属性
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//创建方法
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}",cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){ this.empno = empno;}",cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//添加构造器
		//无参和有参构造器，无参的删掉参数即可
		CtConstructor constructor = new CtConstructor(new CtClass[] {CtClass.intType, pool.get("java.lang.String")}, cc);
		constructor.setBody("{this.empno = empno; this.ename = ename;}");
		cc.addConstructor(constructor);
		cc.writeFile("D:/informatique/EclipseWorkspace/testJavassist");//将上面构造好的类写入到文件夹之中
		System.out.println("生成类成功");
		
		//新生成的文件要用反编译工具XJad查看具体内容
		
	}
	
	
}
