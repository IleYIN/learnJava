package testthread.create;
/**
 * ʹ��Runnable�����߳� �ô������ⵥ�̳еľ�����;���㹲����Դ
 * 
 * 
 * extends��implements������ 
 * extends �Ǽ̳и��ֻ࣬Ҫ�Ǹ��಻������Ϊfinal�����Ǹ��ඨ��Ϊabstract�ľ��ܼ̳У�
 * JAVA�в�֧�ֶ��ؼ̳У����ǿ����ýӿ���ʵ�֣��������õ���implements���̳�ֻ�ܼ̳�һ���࣬
 * ��implements����ʵ�ֶ���ӿڣ��ö��ŷֿ������ˡ�
 * 
 * 1���� ʵ��Runnable�ӿ� + ��дrun()�߳��� --> ��ʵ��ɫ��
 * 2���������߳� ʹ�þ�̬����
 *   ������ʵ��ɫ ���������ɫ+��ʵ��ɫ����  ����.start()�����߳�
 * 
 * @author yinyiliang
 *
 */
public class Programmer implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<1000;i++){
			System.out.println("�ô���");
		}
	}

	
}
