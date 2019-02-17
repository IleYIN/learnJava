package gameUtil;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {
	
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//���ڴ�С
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
	
	
	//����˫���弼��������˸
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		Graphics gOff = offScreenImage.getGraphics();
		
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
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
	
	
}
