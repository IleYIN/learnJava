package test;

/**
 * 测试窗口物体沿着水平和垂直轨迹移动
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gameUtil.GameUtil;
//import gameUtil.GameFrame.PaintThread;

public class GameFrame02 extends Frame{ //GUI编程：AWT，swing类。 JAVA不适合写桌面软件
	
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
//	private boolean left;
	private boolean up;
	@Override//重写windows父类方法
	public void paint(Graphics g) {
//		System.out.println("paint!!!");
	
		g.drawImage(img, (int)x, (int)y, null);
//		if(left){
//			x -= 3;
//		}else{
//			x += 3;
//		}
//		if(x>500-100){
//			left = true;
//		}
//		if(x<0){
//			left = false;
//		}
		if(up){
			y -= 10;
		}else{
			y += 10;
		}
		if(y>500-100){
			up = true;
		}
		if(y<10){
			up = false;
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
		GameFrame02 gf = new GameFrame02();
		gf.launchFrame();
	}
}