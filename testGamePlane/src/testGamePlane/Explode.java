package testGamePlane;

import java.awt.Graphics;
import java.awt.Image;

//��ը��

import gameUtil.GameUtil;

public class Explode {
	double x,y;
	static Image[] imgs = new Image[6];//���ظ�ɹ�������һ�μ��ɲ���ÿ�ζ�����
	//��̬���������ʼ����̬����
	static{
		for(int i=0;i<6;i++) {
			imgs[i] = GameUtil.getImage("images/explo" + i + ".png");
			imgs[i].getWidth(null);//��ΪͼƬ���ص����⣬��һ�θռ��ص�ʱ���ǳ������ģ�����������һ��������ʹͼƬ����
		}
	}
	
	int count;//����
	
	public void draw(Graphics g){
		if (count<=15){
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode(double x, double y){ //������
		this.x = x;
		this.y = y;
	}
}
