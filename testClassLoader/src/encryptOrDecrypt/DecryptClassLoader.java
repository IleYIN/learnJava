package encryptOrDecrypt;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * load the encrypted class �ֽ��� byte code
 * 
 * @author y.yin
 *
 */
public class DecryptClassLoader extends ClassLoader{
	private String rootDir;
	
	public DecryptClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		Class<?> c = findLoadedClass(name);
		
		//Ӧ���Ȳ�ѯ��û�м��ع�����ࡣ����Ѿ����أ���ֱ�ӷ��ؼ��غõ��࣬���û�У�������µ��ࡣ
		if(c!=null) {
			return c;
		} else {
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name); //ί�ɸ��������
			} catch (Exception e) {
//				e.printStackTrace();
			}
			if(c!=null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if(classData == null) {
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
		
	}
	
	private byte[] getClassData(String classname) {//һ��User����  com.bjsxt.test.User 
// --> ��Ŀ¼��������ļ� com/bjsxt/test/User.class   D:/informatique/EclipseWorkspace/testClassLoader/testClassLoader/User.class
		String path = rootDir + "/" + classname.replace('.','/')+".class";
		
		//���е�����ת���ֽ����飬����ʹ��IOUtils
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			is = new FileInputStream(path);
			
			/**
			 * decryption
			 */
			int temp = -1;
			while((temp=is.read()) != -1) {
				baos.write(temp^0xff);//invert
			}
			
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (is != null) {
					is.close();
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (baos != null) {
					baos.close();//�ֽ�����ʵ���Բ��أ���Ϊû�д򿪵ķ���
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
