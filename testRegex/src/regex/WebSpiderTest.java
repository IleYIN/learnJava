package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * web spider get hyper references  (wget...)
 * 
 * Regex
 * 
 * <a[\s\S]+?</a>
 *
 * \s is a shorthand for [ \t\r\n\f], whereas \S equivals to [^ \t\r\n\f]
 * [\s\S] means all including "\n"
 * . means all except "\n"
 * ? here makes + become non greedy mode
 * 
 * 
 * @author y.yin
 *
 */
public class WebSpiderTest {

	/**
	 * get code source of urlStr site
	 * 
	 * @param urlStr
	 * @return
	 */
	public static String getURLContent(String urlStr, String charset) {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			URL url = new URL(urlStr);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));
			
			String temp = "";
			while((temp = reader.readLine()) != null) {
				sb.append(temp);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	
	public static List<String> getMatcherSubstrs(String destStr, String regexStr){
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(destStr);
		
		List<String> result = new ArrayList<String>();
		
		while(m.find()) {
//			System.out.println(m.group());
//			System.out.println(m.group(1));
			result.add(m.group(1));
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		String destStr = getURLContent("https://www.google.com","UTF-8");
//		System.out.println(desStr);
		
//		Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");//get contents containing hyper reference
//		Pattern p = Pattern.compile("href=\".+?\"");//get hyper reference

//		List<String> result = getMatcherSubstrs(destStr, "href=\"(.+?)\"");//get contents of hyper reference
		List<String> result = getMatcherSubstrs(destStr, "href=\"([\\s\\w./:=&;?]+?)\"");// \s or \w or ./:=&;? 

		for (String temp : result) {
			System.out.println(temp);
		}
	}
}
