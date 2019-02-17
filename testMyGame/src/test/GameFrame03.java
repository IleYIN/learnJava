package test;

/**
 * 测试窗口物体沿着任意角度移动
 * 最后试下一个小的台球游戏
 */

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gameUtil.GameUtil;

public class GameFrame03 extends Frame{ //GUI编程：AWT，swing类。 JAVA不适合写桌面软件
	
	Image img = GameUtil.getImage("images/france.png");
	
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(500,500);//窗口大小
		setLocation(100,100);//窗口起点在桌面坐标系下，桌面左上角为原点
		setVisible(true);
		
		new PaintThread().start();//启动重画线程
		
		addWindowListener(new WindowAdapter() { //窗口监听 右键source overridemethod 用于关闭窗口

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//结束当前运行的虚拟机，遇到异常传负数，正常传0即可
			}
		});
	}
	
	private double x=100, y=100;
	private double degree = Math.PI/3; //[0,2pi]  3.14/3
	private double speed = 30;
	@Override//重写windows父类方法
	public void paint(Graphics g) {
//		System.out.println("paint!!!");
	
		g.drawImage(img, (int)x, (int)y, null);
		
		if (speed>0){
			speed -= 0.2;
		} else {
			speed = 0;
		}
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		
		//下面是指碰到壁面就回弹
		if(y>500-140||y<10){
			degree = -degree;
		}
		if(x<0||x>500-160){
			degree = Math.PI-degree;			
		}
	}
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author yinyiliang
	 *
	 */
	class PaintThread extends Thread { //线程
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//40ms
			}
		}
		
	}
	
	
	
	public static void main(String[] args){
		GameFrame03 gf = new GameFrame03();
		gf.launchFrame();
	}
}