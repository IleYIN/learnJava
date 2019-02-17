package pattern;
/**
 * 装饰设计模式
 * 
 * @author yinyiliang
 *
 */
public class Test {

	public static void main(String[] args) {
		Voice v = new Voice();
		v.say();
		Amplifier am = new Amplifier(v);
		am.say();
	}
}
