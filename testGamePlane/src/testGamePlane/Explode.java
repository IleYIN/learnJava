package testGamePlane;

import java.awt.Graphics;
import java.awt.Image;

//爆炸类

import gameUtil.GameUtil;

public class Explode {
	double x,y;
	static Image[] imgs = new Image[6];//加载搞成共享，加载一次即可不用每次都加载
	//静态代码块来初始化静态属性
	static{
		for(int i=0;i<6;i++) {
			imgs[i] = GameUtil.getImage("images/explo" + i + ".png");
			imgs[i].getWidth(null);//因为图片加载的问题，第一次刚加载的时候是出不来的，所以随便调用一个方法来使图片出来
		}
	}
	
	int count;//计数
	
	public void draw(Graphics g){
		if (count<=15){
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode(double x, double y){ //构造器
		this.x = x;
		this.y = y;
	}
}
