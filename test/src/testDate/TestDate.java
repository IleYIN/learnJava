package testDate;

import java.util.Date;

/**
 * ����ʱ��Date����÷�
 * @author yinyiliang
 *
 */
public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();//���ʲô����д�ͱ�ʾ��ǰ����ʱ����Ϊԭ����this
		Date d2 = new Date(1000);//���ʲô����д�ͱ�ʾ��ǰʱ����Ϊԭ����this
		
		long t = System.currentTimeMillis();
		System.out.println(t);
		System.out.println(d);
		System.out.println(d2.toGMTString());//�ܱ�ʾ������ʹ��
		d2.setTime(2000);
		System.out.println(d2.getTime());
		System.out.println(d.before(d2));
		System.out.println(d.equals(d2));
		System.out.println(d.after(d2));
	}
}
