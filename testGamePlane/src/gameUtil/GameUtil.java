package gameUtil;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Ϸ�����г��õĹ�����(�������ͼƬ�ȷ���)
 * @author yinyiliang
 *
 */
public class GameUtil {
	private GameUtil(){
		//������ͨ���Ὣ���췽��˽��
	}
	public static Image getImage(String path){
		BufferedImage img = null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			img = javax.imageio.ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img; //��ΪBufferedImage��Image�����࣬�ʿ�����������
		
//		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
		
		//Toolkit�ǳ����࣬���Բ�����new Toolkit()ʵ�������󡣵���Toolkit�о�̬����getDefaultToolkit(),ͨ������������Ի�ȡ��Toolkit�Ķ���

	}
}
