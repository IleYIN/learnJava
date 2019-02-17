package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gameUtil.GameUtil;

/**基本知识测试类
 * 游戏窗口类
 * @author yinyiliang
 *
 */
public class GameFrame extends Frame{ //GUI编程：AWT，swing类。 JAVA不适合写桌面软件
	
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
	
	/**
	 * paint方法是applet继承自awt中的Component的方法，会在对象加载时自动调用，用来绘制该组件内部的所有内容。如果想重新调用该方法中执行的操作可以使用repaint()方法。
	 * 在现有类中重新定义paint()方法,那么就对父类的paint()方法进行了"屏蔽",当这个类的一个对象调用paint()方法的时候,就不会去调用父类的了,而是调用我们后来在子类中定义的。 
	 */
	@Override//重写windows父类方法
	public void paint(Graphics g) { 
//		System.out.println("paint!!!");
		g.drawLine(100, 100, 200, 200);//此时坐标是以窗口左上角为原点，横轴向右，纵轴向下
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);//通过画矩形的内切圆
		
		Font f = new Font("宋体",Font.BOLD, 100);//粗体 字号100
		g.setFont(f);
		g.drawString("画图", 200, 200);
		g.fillRect(100, 100, 20, 20);
		
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);//给颜色改回来，避免颜色乱套
		
		g.drawImage(img, (int)x, (int)y, null);
		x += 3;
		y += 3;
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
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
