package testDate;

import java.util.Date;

/**
 * 测试时间Date类的用法
 * @author yinyiliang
 *
 */
public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();//如果什么都不写就表示当前本地时刻因为原码有this
		Date d2 = new Date(1000);//如果什么都不写就表示当前时刻因为原码有this
		
		long t = System.currentTimeMillis();
		System.out.println(t);
		System.out.println(d);
		System.out.println(d2.toGMTString());//杠表示不建议使用
		d2.setTime(2000);
		System.out.println(d2.getTime());
		System.out.println(d.before(d2));
		System.out.println(d.equals(d2));
		System.out.println(d.after(d2));
	}
}
