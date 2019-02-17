package file;

import java.io.File;

/**
 * ���·�������·������File����
 * 
 * ���·�� File(String parentPath, String name)     File(File parentPath, String name)
 * 
 * ����·�� File(String name) 
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test02 {

	public static void main(String[] args) {
		String parentPath = "D:/informatique/MyEclipse workspace/test";
		String name = "2.jpg";
		
		//���·�� ��Ը�·��
		File src = new File(parentPath, name);
		//��
		src = new File(new File(parentPath),name);//��File���� ���ڵײ����
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//����·��
		src = new File("D:/informatique/MyEclipse workspace/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//û���̷�windows ��user.dir������Ŀ�¹���
		src = new File("test01.txt");
//		src = new File(".");//.��ʾ��ǰ·��
		System.out.println(src.getName());
		System.out.println(src.getPath());//���·��
		System.out.println(src.getAbsolutePath());
	}
	
}
