package testDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * ����������
 * @author yinyiliang
 *
 */
public class TestCalendar {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		c.set(2001, Calendar.FEBRUARY, 10, 12, 24, 35);//c.set(2001, 1, 10, 12, 24, 35);
//		c.set(Calendar.YEAR, 2001);
//		c.set(Calendar.MONTH, 1);//����
//		c.set(Calendar.DATE, 10);
		Date d = c.getTime();
		
		Calendar e = new GregorianCalendar();
		e.setTime(new Date());//����ʱ��
//		e = c;
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(d);//û��ʱ�����ʱ����ʾ��ǰʱ����
		System.out.println(e.get(Calendar.MONTH));//û��ʱ�����ʱ����ʾ��ǰʱ����
		System.out.println(e.getTime());
		
		System.out.println("###############");
		//�������ڼ���
		c.add(Calendar.YEAR, 30);
		c.add(Calendar.MONTH, -30);
		System.out.println(c.getTime());
	}
	
}
