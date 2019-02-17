package gameUtil;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏开发中常用的工具类(比如加载图片等方法)
 * @author yinyiliang
 *
 */
public class GameUtil {
	private GameUtil(){
		//工具类通常会将构造方法私有
	}
	public static Image getImage(String path){
//		URL u = GameUtil.class.getClassLoader().getResource(path);
//		BufferedImage img = null;
//		try {
//			img = ImageIO.read(u);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return img; //因为BufferedImage是Image的子类，故可以正常返回
		
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
