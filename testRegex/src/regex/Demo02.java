package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo02 {

	public static void main(String[] args) {
		//zsfsfs23333  \w+       w represents number|letter|_
		Pattern p = Pattern.compile("\\w+"); //in java, use two \ 
		
		Matcher m = p.matcher("zsfsfs23333ss&&bbb");
		
//		boolean yesorno = m.matches();
//		//compare the whole char sequence with regex
//		
//		boolean yesorno2 = m.find();
//		//find the next sub sequence which complys with regex, here it finds "bbb"
//		
//		boolean yesorno3 = m.find();//find the next one, here it can't find one, return false
//
//		System.out.println(yesorno);
//		System.out.println(yesorno2);
//		System.out.println(yesorno3);
		
		
//		System.out.println(m.find());
//		System.out.println(m.group());//return what it finds
//		System.out.println(m.find());
//		System.out.println(m.group());
		
		while(m.find()) {
			System.out.println(m.group());
			System.out.println(m.group(0));
			//group() or group(0) returns sub sequence 
		}
	}
}
