package SolarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import gameUtil.GameUtil;

public class Planet extends Star {
	
	//除了图片，坐标。行星沿着某个椭圆运行：长轴、短轴、速度、角度。绕着某个Star飞。
	double longAxis;
	double shortAxis;
	double degree;
	double speeddegree;
	Star center;
	
	boolean satellite;
	
	
	public void draw(Graphics g){
		super.draw(g);
		move();
		if(!satellite){ //不是卫星的时候才画轨迹线
			drawTrace(g);
		}
	}
	
	public void drawTrace(Graphics g){
		double ovalX, ovalY, ovalWidth, ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = (center.x + center.width/2)  - longAxis; //center.x现在是图片的左上角的点
		ovalY = (center.y + center.height/2) - shortAxis;//_x和_y是要画的图形的左上角点坐标
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	public void move(){
		//沿着椭圆轨迹飞行
//		x = (center.x) + longAxis*Math.cos(degree);
//		y = (center.y) + shortAxis*Math.sin(degree);
		x = (center.x + center.width/2) + longAxis*Math.cos(degree);
		y = (center.y + center.height/2) + shortAxis*Math.sin(degree);
		
		degree += speeddegree;
	}
	
	
	//右键source 找constructor构造器
	public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speeddegree) {
		//在Star里加上一个空构造器，因为Planet总是调用父类的空构造器 super();
		super(GameUtil.getImage(imgpath)); //调用了Star父类的宽度和高度
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speeddegree = speeddegree;
	}
	
	public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speeddegree, boolean satellite) {
		this(center, imgpath, longAxis, shortAxis, speeddegree);
		this.satellite = satellite;
	}
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}

}
