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
		BufferedImage img = null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			img = javax.imageio.ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img; //因为BufferedImage是Image的子类，故可以正常返回
		
//		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
		
		//Toolkit是抽象类，所以不能用new Toolkit()实例化对象。但是Toolkit有静态方法getDefaultToolkit(),通过这个方法可以获取到Toolkit的对象。

	}
}
