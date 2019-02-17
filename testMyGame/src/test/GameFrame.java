package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gameUtil.GameUtil;

/**����֪ʶ������
 * ��Ϸ������
 * @author yinyiliang
 *
 */
public class GameFrame extends Frame{ //GUI��̣�AWT��swing�ࡣ JAVA���ʺ�д�������
	
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
	
	/**
	 * paint������applet�̳���awt�е�Component�ķ��������ڶ������ʱ�Զ����ã��������Ƹ�����ڲ����������ݡ���������µ��ø÷�����ִ�еĲ�������ʹ��repaint()������
	 * �������������¶���paint()����,��ô�ͶԸ����paint()����������"����",��������һ���������paint()������ʱ��,�Ͳ���ȥ���ø������,���ǵ������Ǻ����������ж���ġ� 
	 */
	@Override//��дwindows���෽��
	public void paint(Graphics g) { 
//		System.out.println("paint!!!");
		g.drawLine(100, 100, 200, 200);//��ʱ�������Դ������Ͻ�Ϊԭ�㣬�������ң���������
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);//ͨ�������ε�����Բ
		
		Font f = new Font("����",Font.BOLD, 100);//���� �ֺ�100
		g.setFont(f);
		g.drawString("��ͼ", 200, 200);
		g.fillRect(100, 100, 20, 20);
		
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);//����ɫ�Ļ�����������ɫ����
		
		g.drawImage(img, (int)x, (int)y, null);
		x += 3;
		y += 3;
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
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
