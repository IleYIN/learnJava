package SolarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import gameUtil.GameUtil;

public class Planet extends Star {
	
	//����ͼƬ�����ꡣ��������ĳ����Բ���У����ᡢ���ᡢ�ٶȡ��Ƕȡ�����ĳ��Star�ɡ�
	double longAxis;
	double shortAxis;
	double degree;
	double speeddegree;
	Star center;
	
	boolean satellite;
	
	
	public void draw(Graphics g){
		super.draw(g);
		move();
		if(!satellite){ //�������ǵ�ʱ��Ż��켣��
			drawTrace(g);
		}
	}
	
	public void drawTrace(Graphics g){
		double ovalX, ovalY, ovalWidth, ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = (center.x + center.width/2)  - longAxis; //center.x������ͼƬ�����Ͻǵĵ�
		ovalY = (center.y + center.height/2) - shortAxis;//_x��_y��Ҫ����ͼ�ε����Ͻǵ�����
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	public void move(){
		//������Բ�켣����
//		x = (center.x) + longAxis*Math.cos(degree);
//		y = (center.y) + shortAxis*Math.sin(degree);
		x = (center.x + center.width/2) + longAxis*Math.cos(degree);
		y = (center.y + center.height/2) + shortAxis*Math.sin(degree);
		
		degree += speeddegree;
	}
	
	
	//�Ҽ�source ��constructor������
	public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speeddegree) {
		//��Star�����һ���չ���������ΪPlanet���ǵ��ø���Ŀչ����� super();
		super(GameUtil.getImage(imgpath)); //������Star����Ŀ�Ⱥ͸߶�
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
