package testthread.create;
/**
 * ģ���������
 * �������߳� �̳�Thread + ��дrun���߳��壩
 * 
 * ʹ���̣߳������������  + ���ö���.start���� -->�߳�����
 * 
 * @author yinyiliang
 *
 */
public class RabbitTest {

	public static void main(String[] args) {
		//�����������
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();

		//����start����-->�߳�����
		rab.start();//ע�ⲻҪ����run���� �����ڲ����Լ�������ͨ����
		tor.start();
		
		for(int i=0; i<200; i++){
			System.out.println("main-->"+i);
		}
	}
}
