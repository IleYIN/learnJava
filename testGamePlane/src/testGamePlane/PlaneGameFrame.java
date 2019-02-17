package testGamePlane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import gameUtil.GameUtil;
import gameUtil.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg2.jpg");
//	Image plane = GameUtil.getImage("images/plane.png");
	Plane p = new Plane("images/plane2.png", 50, 50);
	
	Explode bao;
	
	Date startTime = new Date();
	Date endTime;
	int period;
	
	ArrayList bulletList = new ArrayList();//容器用于放子弹，在加载窗口的地方来往容器里放。泛型暂时没学，以后学了要加上。
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
//		g.drawImage(plane, 50, 50, null);
		p.draw(g);
		
		//画子弹
		for (int i=0; i<bulletList.size();i++){
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//检测跟飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			
			if (peng){
				p.setLive(false);//让飞机图片消失
				
				if (bao == null){ //用这个是因为只给bao赋一次值，而且endTime也只赋值一次
					bao = new Explode(p.x, p.y);
					
					System.out.println("##################peng!!!");
					endTime = new Date();
					period = (int)((endTime.getTime()-startTime.getTime())/1000); //毫秒化成秒
					
					bao.draw(g);
					
					break;//有一个子弹碰到就可以了，其他的就不用再执行了
				}
			}
		}
		
		if (!p.isLive()){
//			printInfo(g, "GAME OVER", 50, 100, 200, Color.red);
			printInfo(g, "TIME: " + period +" seconds", 30, (int)p.x, (int)p.y, Color.red);
			
			switch (period/10) { //除以10再取整数
			case 0: 
			case 1:
				printInfo(g, "greenhand", 50, 100, 200, Color.red);
				break;
			case 2:
				printInfo(g, "not bad", 50, 200, 200, Color.yellow);
				break;
			case 3:
				printInfo(g, "good", 50, 200, 200, Color.green);
				break;
			default:
				break;
			}
		}
//		printInfo(g, "Score:100", 30, 50, 100, Color.yellow);
	}
	
	/**
	 * 在窗口上打印信息
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g, String str, int size, int x, int y, Color color){
		Color c = g.getColor();
//		g.setColor(Color.red);
		g.setColor(color);
		Font f = new Font("Calibri", Font.BOLD, size);
		g.setFont(f);
//		g.drawString(str, (int)p.x, (int)p.y);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
    public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
    
    public void launchFrame(){//重写
    	super.launchFrame();
    	//增加键盘的监听
    	addKeyListener(new KeyMonitor());
    	//生成一堆子弹
    	for (int i=0; i<15; i++){
    		Bullet b = new Bullet();
    		bulletList.add(b);//把子弹丢到容器里
    	}
    	
    }
    
    //定义为内部类，可以方便地使用外部类的普通属性。下面的功能是可以让键盘控制飞机
    class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("按下："+e.getKeyCode());
			p.addDirection(e);
//			switch (e.getKeyCode()) {
//			case KeyEvent.VK_LEFT://用来获取左虚拟键的ASCII码，其实就是37
//				p.left = true;
//				break;
//			case KeyEvent.VK_UP:
//				p.up = true;
//				break;
//			case KeyEvent.VK_RIGHT:
//				p.right = true;
//				break;
//			case KeyEvent.VK_DOWN:
//				p.down = true;
//				break;
//			}
			
//			switch(e.getKeyCode()){
//			case 37: //左键
//				p.x -= 10;
//				break;
//			case 38: //上键
//				p.y -= 10;
//				break;
//			case 39: //右键
//				p.x += 10;
//				break;
//			case 40: //下键
//				p.y += 10;
//				break;
//			default:
//				break;
//			}
//			p.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("释放："+e.getKeyCode());
			p.minusDirection(e);
//			switch (e.getKeyCode()) {
//			case KeyEvent.VK_LEFT://用来获取左虚拟键的ASCII码，其实就是37
//				p.left = false;
//				break;
//			case KeyEvent.VK_UP:
//				p.up = false;
//				break;
//			case KeyEvent.VK_RIGHT:
//				p.right = false;
//				break;
//			case KeyEvent.VK_DOWN:
//				p.down = false;
//				break;
//			}
		}
    	
    	
    }
}
