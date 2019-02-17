package testHashMap;

/**
 * javabean 存储数据 po bo vo 包含setter getter的访问器的类
 * @author yinyiliang
 *
 */

public class Letter {
	private String name;
	private int count;
	
	//alt+/ 空构造器
	public Letter() {
		super();
	}
	
	public Letter(String name) {
		super();
		this.name = name;
	}
	
	//alt+shift+s --> o 带参数构造器
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	//setter与getter 访问器
	//alt+shift+s -->r -->tab -->enter -->shift+tab -->enter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	 
}
