package pattern;
/**
 * ������
 * ������֮��Ĺ�ϵ
 * �������β�|�ֲ�����
 * ����������
 * 		�ۺϣ����� �����벿�� ��һ�µ��������� ������
 * 		��ϣ����� �����벿�� һ�µ��������� �������
 * �̳У�������
 * ʵ�֣��ӿں�ʵ����
 * 
 * 
 * @author yinyiliang
 *
 */
public class Amplifier {

	private Voice voice;
	
	public Amplifier() {

	}

	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	
	public void say(){
		System.out.println(voice.getVoice()*10000);
	}
}
