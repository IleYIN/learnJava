package testwrappedclass;

/**
 * 测试自动装箱和拆箱
 * @author yinyiliang
 *
 */
public class Test02 {
	public static void main(String[] args) {
//		Integer a = new Integer(1000);
		Integer a = 1000; //jdk5.0之后，自动装箱，编译器改进代码
		Integer b = null;
		
		int c = new Integer(1500); //编译器改进：new Integer(1500).intValue();
//		int d = b; //编译器改进：b.intValue();
		int e = a;
//		System.out.println(d); //会报错
		System.out.println(a); 
		
		Integer f = 1234;
		Integer f2 = 1234;
		
		System.out.println(f == f2); //不是同一个对象
		System.out.println(f.equals(f2));//值是相等的
		
		System.out.println("#################");
		Integer d3 = -129;
		Integer d4 = -129; //[-128,127]之间的数，仍然会当做基本数据类型来处理来提高效率而不是对象，此时会认为两者相等
		System.out.println(d3==d4);
		System.out.println(d3.equals(d4));
				
		
		
	}

}
