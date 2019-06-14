package flyweight;
/**
 * FlyWeight
 * 
 * @author y.yin
 *
 */
public interface ChessFlyWeight {

	void setColor(String c);
	String getColor();
	void display(Coordinate c);
}


/**
 * shared inner state (in common)
 * 
 * @author y.yin
 *
 */
class ConcreteChess implements ChessFlyWeight{

	private String color;
	
	
	
	public ConcreteChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void setColor(String c) {
		this.color = c;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("chess color: "+color);
		System.out.println("chess coordinate: "+c.getX()+"--"+c.getY());
	}
	
}
