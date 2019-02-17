package convertIO;

import java.io.UnsupportedEncodingException;

public class TestConvertCharset {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//解码byte-->char
		String str = "中国";//默认gdk字符集(ANSI)
		
		//编码char-->byte
		byte[] data = str.getBytes();//默认gdk字符集
		//解码byte-->char
		System.out.println(new String(data));//默认gdk字符集
		//编码与解码的字符集相同
		
		//编码char-->byte
		data = str.getBytes();//默认gdk字符集
		//解码byte-->char
		System.out.println(new String(data,0,3));//默认gdk字符集,字节数不完整
		
		//编码char-->byte
		data = str.getBytes("utf-8");//设定utf-8编码字符集
		//解码byte-->char
		System.out.println(new String(data));//默认gdk字符集
		//编码与解码字符集不统一出现乱码
		
		//编码char-->byte
		byte[] data2 = str.getBytes("utf-8");
		//解码byte-->char
		str = new String(data2,"utf-8");
		System.out.println(str);
		//编码与解码的字符集相同
	}
}
