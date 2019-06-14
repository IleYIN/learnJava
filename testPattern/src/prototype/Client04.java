package prototype;
/**
 * test the efficiency of two methods to create objects
 * 
 * if it needs to create a big amount of objects, it will cost more time by new,
 * it can use copy/clone method
 * 
 * 
 * @author y.yin
 *
 */
public class Client04 {
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
	
		testNew(1000);
		testClone(1000);
	}
	
	
	
	public static void testNew(int size) {
		long start = System.currentTimeMillis();
		for(int i=0; i<size; i++) {
			Laptop t = new Laptop();
		}
		long end = System.currentTimeMillis();
		System.out.println("new cost: " +(end-start));
	}
	
	public static void testClone(int size) throws CloneNotSupportedException {
		long start = System.currentTimeMillis();
		Laptop t =new Laptop();		
		for(int i=0; i<size; i++) {
			Laptop temp = (Laptop) t.clone();
		}
		long end = System.currentTimeMillis();
		System.out.println("clone cost: " +(end-start));
	}
	
}

class Laptop implements Cloneable {
	public Laptop() {
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//use directly the clone() method in object objective
		return obj;
	}
}
