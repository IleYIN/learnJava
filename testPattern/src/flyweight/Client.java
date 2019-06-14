package flyweight;

public class Client {
	public static void main(String[] args) {
		
		//color shared
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("black");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("black");
		System.out.println(chess1);
		System.out.println(chess2);
		
		//coordinate unshared
		System.out.println("--add outer state dealing");
		chess1.display(new Coordinate(10,10));
		chess2.display(new Coordinate(20,20));
	}
}
