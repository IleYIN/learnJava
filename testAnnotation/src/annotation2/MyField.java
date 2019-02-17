package annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来说明表格的属性 列名 类型 长度
 * @author yinyiliang
 *
 */


@Target(value= {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {

	String columnName();
	String type();
	int length();
}
