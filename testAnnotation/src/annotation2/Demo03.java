package annotation2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ʹ�÷����ȡע�����Ϣ��ģ�⴦��ע����Ϣ������
 * 
 * @author yinyiliang
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("annotation2.MyStudent");
			
			//����������ע��
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation a : annotations) {
				System.out.println(a);
			}
			
			//������ָ��ע��
			MyTable mt = (MyTable) clazz.getAnnotation(MyTable.class);
			System.out.println(mt.value());
			
			//���������Ե�ע��
			Field f = clazz.getDeclaredField("studentName");
			MyField mf = f.getAnnotation(MyField.class);
			System.out.println(mf.columnName()+"--"+mf.type()+"--"+mf.length());
			
			
			//���ݻ�õı������ֶε���Ϣ��ƴ��DDL��䣬Ȼ��ʹ��JDBCִ�����SQL�������ݿ���������صı�
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
