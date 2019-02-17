package testDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		DateFormat df2 = new SimpleDateFormat("yy-MM-dd hh:mm:ss,属于本年的第w周");
		Date d = new Date(1241242320);
		String str = df.format(d);
		String str2 = df2.format(d);//将时间对象按照格式化字符串，转化成字符串
		System.out.println(str);
		System.out.println(str2);
		
		System.out.println("#####################");
		String str3 = "1977,7,7";
		DateFormat df3 = new SimpleDateFormat("yyyy,MM,dd");
		try {
			Date d3 = df3.parse(str3);
			System.out.println(d3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
