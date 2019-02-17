package SolarSystem;

import java.awt.Graphics;
import java.awt.Image;

import gameUtil.Constant;
import gameUtil.GameUtil;
import gameUtil.MyFrame;

/**
 * 太阳系的主窗口
 * @author yinyiliang
 *
 */
public class SolarFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Star earth = new Star("images/earth.png",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
	Planet china = new Planet(earth, "images/china.png", 250, 200, 0.1);
	Planet france = new Planet(earth, "images/france.png", 150,50,0.05);
	Planet hongkong = new Planet(china, "images/hongkong.png",120,120,0.15,true);
	Planet uk = new Planet(earth, "images/uk.png", 350,150,0.05);
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		earth.draw(g);
		china.draw(g);
		france.draw(g);
		hongkong.draw(g);
		uk.draw(g);
	}
	
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
