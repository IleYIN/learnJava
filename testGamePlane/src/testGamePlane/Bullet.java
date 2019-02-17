package testGamePlane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gameUtil.Constant;

public class Bullet extends GameObject {
	
	double degree;
//	double x,y;
//	int speed = 3;
//	int width, height;
	
//	public Rectangle getRect() {
//		return new Rectangle((int)x, (int)y, width, height);
//	}

	public Bullet(){
		degree = Math.random()*Math.PI*2;//任意方向发射
		
		x = Constant.GAME_WIDTH/2;//发射中心在中间
		y = Constant.GAME_HEIGHT/2;
		
		width = 10;
		height = 10;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);

		//下面是指碰到壁面就回弹
				if(y>Constant.GAME_HEIGHT-height*2||y<height+30){
					degree = -degree;
				}
				if(x<width||x>Constant.GAME_WIDTH-width*2){
					degree = Math.PI-degree;			
				}
				
		g.setColor(c);
	}

}
