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
public class Rabbit extends Thread {
	//alt+shift+s-->override ����alt+/ �ҵ�run����
	@Override
	public void run() {
		for(int i=0; i<100; i++){
			System.out.println("��������"+i+"��");
		}
	}
}


class Tortoise extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<100; i++){
			System.out.println("�ڹ�����"+i+"��");
		}
	}
}