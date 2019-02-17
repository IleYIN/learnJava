package annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.TYPE})//只能修饰类型
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTable {//只有一个参数，用来和表名对应

	String value();
}
