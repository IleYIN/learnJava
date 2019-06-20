package testClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * net类加载器
 * 
 * @author yinyiliang
 *
 */
public class NetClassLoader extends ClassLoader {

	//传一个User类名   --> www.sxt.cn/myjava  com/bjsxt/test/User.class
	//找到后通过IO流加载到内存里
	private String rootUrl;
	
	public NetClassLoader(String rootDir) {
		this.rootUrl = rootDir;
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
// --> 在URL下找相关文件 com/bjsxt/test/User.class 
		String path = rootUrl + "/" + classname.replace('.','/')+".class";
		
		//流中的数据转成字节数组，可以使用IOUtils
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			URL url = new URL(path);
			
			is = url.openStream();
			
			byte[] buffer = new byte[1024];
			int temp = 0;
			while ((temp = is.read(buffer)) != -1) {
				baos.write(buffer,0,temp);
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
