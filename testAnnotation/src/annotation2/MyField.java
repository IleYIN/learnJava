package annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����˵���������� ���� ���� ����
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
