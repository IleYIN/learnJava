package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Ӧ�÷����API����ȡ�����Ϣ��������֡����ԡ��������������ȣ�
 * @author yinyiliang
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		String path = "test.bean.User";
		
		try {
			Class clazz = Class.forName(path);
			
			//��ȡ�������
			System.out.println(clazz.getName());
			System.out.println(clazz.getSimpleName());
			
			//��ȡ������Ϣ
//			Field[] fields = clazz.getFields();//ֻ�ܻ�ȡpublic��field
			Field[] fields = clazz.getDeclaredFields();//�������fields
			Field f = clazz.getDeclaredField("uname");
			
			System.out.println(f);
			System.out.println(fields.length);
			for(Field temp:fields) {
				System.out.println("���ԣ�"+temp);
			}
			
			//��ȡ������Ϣ
			Method[] methods = clazz.getDeclaredMethods();
			Method m = clazz.getDeclaredMethod("getUname", null);
			Method m2 = clazz.getDeclaredMethod("setUname", String.class);//�в����İѲ�����Classд������������
			
			for(Method temp:methods) {
				System.out.println("������"+temp);
			}
			
			//��ȡ��������Ϣ
			Constructor[] cons = clazz.getDeclaredConstructors();
			for(Constructor temp:cons) {
				System.out.println("��������"+temp);
			}
			
			Constructor c = clazz.getDeclaredConstructor(null);
			System.out.println(c);
			c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}