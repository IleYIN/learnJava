package testSort.refType;
//实体类 无接口 另加其他业务类来Comparator

public class Goods {
	//商品名称
	private String name;
	//价格
	private double price;
	//收藏量
	private int fav;
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Goods(String name, double price, int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}



	public int getFav() {
		return fav;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return ("商品名："+this.name+"，收藏量："+this.fav+"，价格："+this.price+"\n");
	}
	
}
