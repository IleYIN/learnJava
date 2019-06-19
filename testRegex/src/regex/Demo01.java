package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("([a-z]+)([0-9]+)"); //in java, use two \ 
		
		Matcher m = p.matcher("aa232**ssd445*sfs223");
		
		while(m.find()) {
//			System.out.println(m.group()); same with m.group(0)
			System.out.println(m.group(0));
			System.out.println(m.group(1));//([a-z]+)
			System.out.println(m.group(2));//([0-9]+)
		}
	}
}
