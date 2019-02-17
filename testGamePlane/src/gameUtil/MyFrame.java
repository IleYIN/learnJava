package gameUtil;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {
	
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//窗口大小
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
	
	
	//利用双缓冲技术消除闪烁
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		Graphics gOff = offScreenImage.getGraphics();
		
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
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
	
	
}
