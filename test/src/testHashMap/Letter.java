package testHashMap;

/**
 * javabean �洢���� po bo vo ����setter getter�ķ���������
 * @author yinyiliang
 *
 */

public class Letter {
	private String name;
	private int count;
	
	//alt+/ �չ�����
	public Letter() {
		super();
	}
	
	public Letter(String name) {
		super();
		this.name = name;
	}
	
	//alt+shift+s --> o ������������
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	//setter��getter ������
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
