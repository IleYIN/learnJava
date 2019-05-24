package testClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �Զ����ļ�ϵͳ�������
 * 
 * @author yinyiliang
 *
 */
public class FileSystemClassLoader extends ClassLoader {

	//��һ��User����   --> ��Ŀ¼��������ļ�  D:/informatique/EclipseWorkspace/testClassLoader/testClassLoader/User.class
	//�ҵ���ͨ��IO�����ص��ڴ���
	private String rootDir;
	
	public FileSystemClassLoader(String rootDir) {
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
			c = parent.loadClass(name); //ί�ɸ��������
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
					baos.close();//�ֽ�����ʵ���Բ��أ���Ϊû�д򿪵ķ���
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
