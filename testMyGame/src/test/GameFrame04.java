package test;

import java.awt.Graphics;
import java.awt.Image;

import gameUtil.GameUtil;
import gameUtil.MyFrame;
/**
 * 椭圆轨迹的实现
 * @author yinyiliang
 *
 */

public class GameFrame04 extends MyFrame{
	
	Image img = GameUtil.getImage("images/france.png");
	
	private double x=100, y=100;
	private double degree = Math.PI/3; //[0,2pi]  3.14/3
	@Override//重写windows父类方法
	public void paint(Graphics g) {
//		System.out.println("paint!!!");
	
		g.drawImage(img, (int)x, (int)y, null);
		
		x = 150+150*Math.cos(degree);
		y = 200+50*Math.sin(degree);
		
		degree += 0.1;
		
	}

	public static void main(String[] args){
		GameFrame04 gf = new GameFrame04();
		gf.launchFrame();
	}
}
