package encryptOrDecrypt;

import testClassLoader.FileSystemClassLoader;

/**
 * Encrypt or Decrypt (invert)
 * 
 * @author y.yin
 *
 */
public class Demo04 {

	public static void main(String[] args) throws ClassNotFoundException {
		int a = 3;//00000011
		System.out.println(Integer.toBinaryString(a^0xff));//invert
		
		//java.lang.ClassFormatError: Incompatible magic value, need decryption
//		FileSystemClassLoader loader = new FileSystemClassLoader("D:/y.yin/JavaWS/temp");
//		Class<?> c = loader.loadClass("HelloWorld");
//		System.out.println(c);
		
		DecryptClassLoader loader = new DecryptClassLoader("D:/y.yin/JavaWS/temp");
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	}
}
