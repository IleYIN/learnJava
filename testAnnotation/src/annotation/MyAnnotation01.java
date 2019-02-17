package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value=ElementType.METHOD)//��ζ��ע��ֻ�����ڷ���ǰ��
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {

	String studentName() default "";//��������Ĭ��ֵ�������ǿ��ַ���
	int age() default 0;
	int id() default -1; //-1һ����ָ������   String indexOf("abc") -1
	
	String[] schools() default {"��ѧ1","��ѧ2"};
}
