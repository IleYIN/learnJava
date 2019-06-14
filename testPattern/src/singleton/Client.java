package singleton;

//low resource occupation, no need to lazy load -> enumeration is better than hungry mode 
//high resource occupation, need to lazy load -> static inner class is better than lazy mode 

public class Client {

	public static void main(String[] args) {
		SingletonDemo03 s1 = SingletonDemo03.getInstance();
		SingletonDemo03 s2 = SingletonDemo03.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(SingletonDemo04.getInstance()==SingletonDemo04.getInstance());
	}
}
