package gameUtil;

import java.awt.Frame;
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
