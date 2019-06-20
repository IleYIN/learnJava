package encryptOrDecrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Encryption Util
 * 
 * @author y.yin
 *
 */
public class EncryptUtil {
	
	public static void main(String[] args) {
		encrypt("D:/y.yin/JavaWS/HelloWorld.class","D:/y.yin/JavaWS/temp/HelloWorld.class");
	}
	
	public static void encrypt(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			
			int temp = -1;
			while((temp=fis.read()) != -1) {
				fos.write(temp^0xff);//invert
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { //ctrl + shift + z
				if (fis != null) {
					fis.close();
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
			try { 
				if (fos != null) {
					fos.close();
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
