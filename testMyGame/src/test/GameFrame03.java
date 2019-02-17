package test;

/**
 * ���Դ���������������Ƕ��ƶ�
 * �������һ��С��̨����Ϸ
 */

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gameUtil.GameUtil;

public class GameFrame03 extends Frame{ //GUI��̣�AWT��swing�ࡣ JAVA���ʺ�д�������
	
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
	private double degree = Math.PI/3; //[0,2pi]  3.14/3
	private double speed = 30;
	@Override//��дwindows���෽��
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
		
		
		//������ָ��������ͻص�
		if(y>500-140||y<10){
			degree = -degree;
		}
		if(x<0||x>500-160){
			degree = Math.PI-degree;			
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
		GameFrame03 gf = new GameFrame03();
		gf.launchFrame();
	}
}