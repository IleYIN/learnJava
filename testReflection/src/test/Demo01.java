package test;
/**
 * 测试java.lang.Class对象的获取方式
 * 
 * @author yinyiliang
 *
 */

@SuppressWarnings("all")
public class Demo01 {

	public static void main(String[] args) {
		String path = "test.bean.User";
		
		try {
			//被加载的类会生成一个对象，对象表示或封装一些数据。
			//一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息被存放到对应的Class对象当中
			Class/*<?>*/ clazz = Class.forName(path);
			System.out.println(clazz);
			System.out.println(clazz.hashCode());
			
			
			//一个类只有一个Class对象
			Class clazz2 = Class.forName(path);
			System.out.println(clazz2);
			System.out.println(clazz2.hashCode());
			
			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz==strClazz2);//是同一个对象
			
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
