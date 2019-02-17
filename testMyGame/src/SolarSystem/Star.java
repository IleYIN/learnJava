package SolarSystem;

import java.awt.Graphics;
import java.awt.Image;

import gameUtil.GameUtil;

public class Star {
	Image img;
	double x,y;
	int width, height;

	
	
	public Star(){
		
	}
	
	public Star(Image img){
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public void draw(Graphics g){
		g.drawImage(img,(int)x-width,(int)y-height,null);
	}
	public Star(Image img, double x, double y){
		this(img);
		this.x = x;
		this.y = y;
	}
	public Star(String imgpath, double x, double y){
//		this.img = GameUtil.getImage(imgpath);
//		this.x = x;
//		this.y = y;
		this(GameUtil.getImage(imgpath), x, y); //通过this调用另一个方法
	}
}
