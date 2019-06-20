package encryptOrDecrypt;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * load the encrypted class 字节码 byte code
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
		
		//应该先查询有没有加载过这个类。如果已经加载，则直接返回加载好的类，如果没有，则加载新的类。
		if(c!=null) {
			return c;
		} else {
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name); //委派给父类加载
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
	
	private byte[] getClassData(String classname) {//一个User类名  com.bjsxt.test.User 
// --> 在目录下找相关文件 com/bjsxt/test/User.class   D:/informatique/EclipseWorkspace/testClassLoader/testClassLoader/User.class
		String path = rootDir + "/" + classname.replace('.','/')+".class";
		
		//流中的数据转成字节数组，可以使用IOUtils
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
					baos.close();//字节流其实可以不关，因为没有打开的方法
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
