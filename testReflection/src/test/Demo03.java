package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import test.bean.User;


/**
 * ͨ������API��̬�Ĳ�����������������������
 * 
 * @author yinyiliang
 *
 */
public class Demo03 {

	public static void main(String[] args) {
	
		String path = "test.bean.User";
		try {
			Class<User> clazz = (Class<User>)Class.forName(path);
			
			//ͨ����̬���ù��췽�����������
			User u = clazz.newInstance();//�������޲ι��췽��
			System.out.println(u);
			
			Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = c.newInstance(101,18,"����2");
			System.out.println(u2.getUname());
			
			
			//ͨ������API������ͨ����
			User u3 = clazz.newInstance();
			
			//���������൱��u3.setUname("����3");��̬���÷���
			Method method = clazz.getDeclaredMethod("setUname",String.class);
			method.invoke(u3, "����3");
			
			System.out.println(u3.getUname());
			
			
			//ͨ������API��������
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("uname");
			//f.set(u4, "����4");//���������ܷ���˽������
			
			f.setAccessible(true);//��ʾ������Բ�������ȫ����ˣ�����ֱ�ӷ���
			f.set(u4, "����4");//ͨ������ֱ��д����
			
			System.out.println(u4.getUname());//����ֱ�ӵ���
			System.out.println(f.get(u4));//ͨ������ֱ�Ӷ����Ե�ֵ
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}