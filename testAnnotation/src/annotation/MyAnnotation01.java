package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value=ElementType.METHOD)//意味着注解只能用在方法前面
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {

	String studentName() default "";//参数名加默认值，这里是空字符串
	int age() default 0;
	int id() default -1; //-1一般是指不存在   String indexOf("abc") -1
	
	String[] schools() default {"大学1","大学2"};
}
