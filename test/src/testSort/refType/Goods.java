package testSort.refType;
//ʵ���� �޽ӿ� �������ҵ������Comparator

public class Goods {
	//��Ʒ����
	private String name;
	//�۸�
	private double price;
	//�ղ���
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
		return ("��Ʒ����"+this.name+"���ղ�����"+this.fav+"���۸�"+this.price+"\n");
	}
	
}
