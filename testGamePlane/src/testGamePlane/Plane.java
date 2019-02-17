package testGamePlane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import gameUtil.GameUtil;

public class Plane extends GameObject {
	
	private boolean left, up, right, down;
	
	private boolean live = true;
	
//	Image img = GameUtil.getImage("images/plane.png");
//	Image img;
//	double x,y;
//	int speed = 3;
//	
//	
//	int width, height;
//	
//	public Rectangle getRect() {
////		Rectangle r = new Rectangle((int)x, (int)y, img.getWidth(null), img.getHeight(null));
////		return r;
//		return new Rectangle((int)x, (int)y, width, height);
//	}
	
	//右键source添加get方法
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g){
	
			if (live){
				g.drawImage(img, (int)x, (int)y, null);
				move();
			}
	}
	
	public void move(){
//	public void move(KeyEvent e){
//		switch(e.getKeyCode()){
//		case 37: //左键
//			x -= 10;
//			break;
//		case 38: //上键
//			y -= 10;
//			break;
//		case 39: //右键
//			x += 10;
//			break;
//		case 40: //下键
//			y += 10;
//			break;
//		default:
//			break;
//		}
		if (left){
			x -= speed;
		}
		if (right){
			x += speed;
		}
		if (up){
			y -= speed;
		}
		if(down){
			y += speed;
		}
	}
	
	public void addDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT://用来获取左虚拟键的ASCII码，其实就是37
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	public void minusDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT://用来获取左虚拟键的ASCII码，其实就是37
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
	
	public Plane() {
		
	}

	public Plane(String imgpath, double x, double y) {
		this.img = GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	
	
}
