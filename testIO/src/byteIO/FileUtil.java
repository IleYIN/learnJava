package byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	


	
	/**
	 * �ļ�����
	 * @param src
	 * @param dest
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void copyFile(File src, File dest) throws FileNotFoundException,IOException {

		if(! src.isFile() && src.exists()){//�����ļ�
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
			//��throw�˾Ͳ���return��
		}
		
		//���destΪ�ļ��У����޷����ʣ����Ըĳ��ڸ��ļ���������ļ�·��
		if(dest.isDirectory()){
			dest = new File(dest,src.getName());
		}
		
		//ѡ����
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest,true));
		
		//�ļ����� ѭ��+��ȡ+д��
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len=is.read(flush))){
			os.write(flush,0,len);//��len�ĺô����ж��پ�д����  ����û���˻���д
		}
		os.flush();//ǿ��ˢ��
		
		//�ر��� ��򿪵��ȹر�
		os.close();
		is.close();//���ü��жϷǿ� ��Ϊ������null
	}
	
	/**
	 * �ļ�����
	 * ���� File���� --> String path
	 * @param srcPath
	 * @param destPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
		//������ϵ Դ��������Ϊ�ļ��� + Ŀ�ĵأ��ļ����Բ����ڣ�
		
		copyFile(new File(srcPath),new File(destPath));
	}
	
	
	
	/**
	 * �����ļ���·��
	 * 
	 * @param srcPath
	 * @param destPath
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(String srcPath, String destPath) throws FileNotFoundException, IOException{

		File src = new File(srcPath);
		File dest = new File(destPath);
		
		//����
			copyDir(src, dest);
	}
	
	
	
	
	/**
	 * �����ļ��н���Ŀ���ļ��е�·������Ȼ����ÿ����ļ�������
	 *
	 * @param src
	 * @param dest
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(File src, File dest) throws FileNotFoundException, IOException {
		if(src.isDirectory()){//������ļ����򴴽��ļ���
			dest = new File(dest, src.getName());//File(String parent, String child) �ڸ�Ŀ¼�ﴴ����child����һ���Ķ���
			//���������destPath·���´����˺�src����һ���Ķ����ļ���1��������dest��ע���ʱ��û�д����ļ��У�ֻ�Ǵ�����·�����󣬺���dest.mkdirs()���Ǵ������ļ���
		
			//���ⳬ���ļ��к͸�Ŀ¼��������Ŀ¼�����
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				System.out.println("��Ŀ¼���ܿ�������Ŀ¼��");
				return;
			}
			
		}
	
		copyDirContent(src, dest);//��Դ�ļ���1��Ķ���������Ŀ���ļ���1��
	
	}
	
	
	
	/**
	 * �����ļ����������
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException 
	 */
	public static void copyDirContent(File src, File dest) throws FileNotFoundException, IOException{
		if(src.isFile()){//Դ�ļ����ļ���ֱ��copy
			try {
//				System.out.println(dest.getAbsolutePath());
				
				FileUtil.copyFile(src, dest);
				
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				throw e;
			} catch (IOException e) {
				//e.printStackTrace();
				throw e;
			}
		}else if(src.isDirectory()){//Դ�ļ����ļ���
			
			//ȷ��Ŀ���ļ��к�Ŀ���ļ���·������
			dest.mkdirs();//��dest��·�������ļ��У������Ժ��������ļ���
//			System.out.println(dest.getAbsolutePath());
			
			//��ȡ��һ��Ŀ¼|�ļ���
			for (File sub:src.listFiles()){//Դ�ļ���1��Ķ���������Ŀ���ļ���1��·����
			
//				System.out.println(sub.getAbsolutePath());
				
				copyDirContent(sub, new File(dest,sub.getName()));//����ݹ飬����������ʱ�µ�destλ������File(dest,sub.getName()
			}
		}else throw new FileNotFoundException("�ļ�������");

	}


}
