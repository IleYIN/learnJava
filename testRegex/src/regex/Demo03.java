package regex;
/**
 * replace
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo03 {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("[0-9]"); 
		
		Matcher m = p.matcher("zsfsfs23333ss&&bbb");
		
		//replace
		String newStr = m.replaceAll("#");
		System.out.println(newStr);
	}
}
