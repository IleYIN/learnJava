package file;

import java.io.File;

/**
 * ��������
 * ·���ָ��� ;
 * ���Ʒָ���  Windows \    ���� /
 * 
 * @author yinyiliang
 *
 */
public class Test01 {

	public static void main(String[] args) {
		
		System.out.println(File.pathSeparator);//;·���ָ���
		System.out.println(File.separator);// \
		
		//·���ļ��ֱ�����ʽ
		String path = "D:\\informatique\\MyEclipse workspace\\test\\pw.txt";//ת��
		
		path = "D:"+File.separator+"informatique"+File.separator+"MyEclipse workspace"+File.separator+"test"+File.separator+"pw.txt";
		//�ʺ϶�̬����
		
		path = "D:/informatique/MyEclipse workspace/test/pw.txt";
		//�Ƽ����ַ�ʽ
	}
}
