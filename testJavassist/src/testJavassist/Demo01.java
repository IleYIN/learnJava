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
 * ����ʹ��javassit����һ���µ���
 * 
 * @author yinyiliang
 *
 */
public class Demo01 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		//���
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("bean.Emp");
		
		//��������
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//��������
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}",cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){ this.empno = empno;}",cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//��ӹ�����
		//�޲κ��вι��������޲ε�ɾ����������
		CtConstructor constructor = new CtConstructor(new CtClass[] {CtClass.intType, pool.get("java.lang.String")}, cc);
		constructor.setBody("{this.empno = empno; this.ename = ename;}");
		cc.addConstructor(constructor);
		cc.writeFile("D:/informatique/EclipseWorkspace/testJavassist");//�����湹��õ���д�뵽�ļ���֮��
		System.out.println("������ɹ�");
		
		//�����ɵ��ļ�Ҫ�÷����빤��XJad�鿴��������
		
	}
	
	
}
