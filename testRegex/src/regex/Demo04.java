package regex;
import java.util.Arrays;
/**
 * replace
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo04 {

	public static void main(String[] args) {

		String str = "a,b,c";
		String[] arrs = str.split(",");
		System.out.println(Arrays.toString(arrs));
		
		String str2 = "a435s4egf4s3g";
		String[] arrs2 = str2.split("\\d+");
		System.out.println(Arrays.toString(arrs2));
	}
}
