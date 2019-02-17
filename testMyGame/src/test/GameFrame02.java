package test;

/**
 * ���Դ�����������ˮƽ�ʹ�ֱ�켣�ƶ�
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

public class GameFrame02 extends Frame{ //GUI��̣�AWT��swing�ࡣ JAVA���ʺ�д�������
	
	Image img = GameUtil.getImage("images/france.png");
	
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(500,500);//���ڴ�С
		setLocation(100,100);//�����������������ϵ�£��������Ͻ�Ϊԭ��
		setVisible(true);
		
		new PaintThread().start();//�����ػ��߳�
		
		addWindowListener(new WindowAdapter() { //���ڼ��� �Ҽ�source overridemethod ���ڹرմ���

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//������ǰ���е�������������쳣��������������0����
			}
		});
	}
	
	private double x=100, y=100;
//	private boolean left;
	private boolean up;
	@Override//��дwindows���෽��
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
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 * @author yinyiliang
	 *
	 */
	class PaintThread extends Thread { //�߳�
		
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