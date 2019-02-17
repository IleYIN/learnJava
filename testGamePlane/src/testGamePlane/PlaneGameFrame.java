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
	
	ArrayList bulletList = new ArrayList();//�������ڷ��ӵ����ڼ��ش��ڵĵط�����������š�������ʱûѧ���Ժ�ѧ��Ҫ���ϡ�
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
//		g.drawImage(plane, 50, 50, null);
		p.draw(g);
		
		//���ӵ�
		for (int i=0; i<bulletList.size();i++){
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//�����ɻ�����ײ
			boolean peng = b.getRect().intersects(p.getRect());
			
			if (peng){
				p.setLive(false);//�÷ɻ�ͼƬ��ʧ
				
				if (bao == null){ //���������Ϊֻ��bao��һ��ֵ������endTimeҲֻ��ֵһ��
					bao = new Explode(p.x, p.y);
					
					System.out.println("##################peng!!!");
					endTime = new Date();
					period = (int)((endTime.getTime()-startTime.getTime())/1000); //���뻯����
					
					bao.draw(g);
					
					break;//��һ���ӵ������Ϳ����ˣ������ľͲ�����ִ����
				}
			}
		}
		
		if (!p.isLive()){
//			printInfo(g, "GAME OVER", 50, 100, 200, Color.red);
			printInfo(g, "TIME: " + period +" seconds", 30, (int)p.x, (int)p.y, Color.red);
			
			switch (period/10) { //����10��ȡ����
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
	 * �ڴ����ϴ�ӡ��Ϣ
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
    
    public void launchFrame(){//��д
    	super.launchFrame();
    	//���Ӽ��̵ļ���
    	addKeyListener(new KeyMonitor());
    	//����һ���ӵ�
    	for (int i=0; i<15; i++){
    		Bullet b = new Bullet();
    		bulletList.add(b);//���ӵ�����������
    	}
    	
    }
    
    //����Ϊ�ڲ��࣬���Է����ʹ���ⲿ�����ͨ���ԡ�����Ĺ����ǿ����ü��̿��Ʒɻ�
    class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("���£�"+e.getKeyCode());
			p.addDirection(e);
//			switch (e.getKeyCode()) {
//			case KeyEvent.VK_LEFT://������ȡ���������ASCII�룬��ʵ����37
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
//			case 37: //���
//				p.x -= 10;
//				break;
//			case 38: //�ϼ�
//				p.y -= 10;
//				break;
//			case 39: //�Ҽ�
//				p.x += 10;
//				break;
//			case 40: //�¼�
//				p.y += 10;
//				break;
//			default:
//				break;
//			}
//			p.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("�ͷţ�"+e.getKeyCode());
			p.minusDirection(e);
//			switch (e.getKeyCode()) {
//			case KeyEvent.VK_LEFT://������ȡ���������ASCII�룬��ʵ����37
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
