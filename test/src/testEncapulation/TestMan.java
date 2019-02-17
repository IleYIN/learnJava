package testEncapulation;

public class TestMan {
	private String name;
	private String id;
	private boolean man;
	public boolean isMan() {
		return man; //boolean isMan 不是 getMan
		
	}

	public void setMan(boolean man) {
		this.man = man;
	}

	public static int cc;
	public static final int MAX_SPEED = 120;
	
	public String getName(){
		return this.name;//可不加this
	}
	
	public void setName(String name){
		this.name = name;
	}
//右键source-generate setters and getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
