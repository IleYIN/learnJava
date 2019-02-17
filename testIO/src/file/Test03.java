package file;

import java.io.File;
import java.io.IOException;

/**
 * File���÷���
 * 
 * @author yinyiliang
 *
 */
public class Test03 {

	public static void main(String[] args){
//		test1();
		test2();
//		try {
//			test3();
//		} catch (IOException e) {
//			System.out.println("�ļ�����ʧ��");
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * ������Ϣ
	 */
	
	public static void test1(){
	
//		File src = new File("2.jpg");
		File src = new File("D:/informatique/MyEclipse workspace/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());//����Ǿ���·�����ؾ���·�������򷵻����·��
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());//������һ��Ŀ¼���������ԣ�����null
	}
	
	
	/**
	 * �ж�������Ϣ
	 */
	public static void test2(){
//		String path = "2.txt";//false
		String path = "D:/informatique/MyEclipse workspace/testIO/1.txt";
//		String path = "D:/informatique/MyEclipse workspace/test";
		
		File src = new File(path);
		System.out.println("�ļ��Ƿ����"+src.exists());
		//�Ƿ�ɶ�д
		System.out.println("�Ƿ�ɶ�д"+src.canRead()+src.canWrite());
		
		System.out.println("���ļ������ļ���"+src.isFile()+src.isDirectory());
		//�޷��жϺ�׺�Ƿ�Ϊ�ļ���
		
		if(src.isFile()){
			System.out.println("�ļ�");
		}else if(src.isDirectory()){
			System.out.println("�ļ���");
		}else{
			System.out.println("�ļ�������");
		}
		
		System.out.println(src.isAbsolute());//�Ƿ�Ϊ����·��
		System.out.println(src.length());//ֻ�ܶ�ȡ�ļ����ֽ��� �ļ��еĲ���
		
	}

	/**
	 * ����ɾ���ļ�
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void test3() throws IOException, InterruptedException{
		
		String path = "D:/informatique/MyEclipse workspace/testIO/1.jpg";
		File src = new File(path);//������ϵ
////		if(!src.exists()){
//			boolean flag = src.createNewFile();//���ڷ���false
//			System.out.println(flag?"�ɹ�":"ʧ��");
////		}
			
		boolean flag = src.delete();
		System.out.println(flag?"�ɹ�":"ʧ��");
		
//		static createTempFile(ǰ׺3���ֽڳ�,��׺Ĭ��.temp) Ĭ����ʱ�ռ�
//		static createTempFile(ǰ׺3���ֽڳ�,��׺Ĭ��.temp,Ŀ¼)
		File temp = File.createTempFile("tes", ".temp", new File("D:/informatique/MyEclipse workspace/testIO"));
		
		Thread.sleep(5000);
		temp.deleteOnExit();//�˳���ɾ��
	}
}
