package pattern;
/**
 * װ�����ģʽ
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
