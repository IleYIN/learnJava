package test;
/**
 * ����java.lang.Class����Ļ�ȡ��ʽ
 * 
 * @author yinyiliang
 *
 */

@SuppressWarnings("all")
public class Demo01 {

	public static void main(String[] args) {
		String path = "test.bean.User";
		
		try {
			//�����ص��������һ�����󣬶����ʾ���װһЩ���ݡ�
			//һ���౻���غ�JVM�ᴴ��һ����Ӧ�����Class������������ṹ��Ϣ����ŵ���Ӧ��Class������
			Class/*<?>*/ clazz = Class.forName(path);
			System.out.println(clazz);
			System.out.println(clazz.hashCode());
			
			
			//һ����ֻ��һ��Class����
			Class clazz2 = Class.forName(path);
			System.out.println(clazz2);
			System.out.println(clazz2.hashCode());
			
			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz==strClazz2);//��ͬһ������
			
			Class intClazz = int.class;
			
			int[] arr01 = new int[10];//number of dimension = 1
			int[] arr02 = new int[30];//number of dimension = 1
			
			int[][] arr03 = new int[30][10];
			double[] arr04 = new double[10];
			
			
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
