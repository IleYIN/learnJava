package testthread.create;
/**
 * ��̬���� ���ģʽ
 * 
 * ��ʵ��ɫ
 * �����ɫ ������ʵ��ɫ������
 * ���� ʵ����ͬ�Ľӿ�
 * 
 * @author yinyiliang
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		
		//������ʵ��ɫ
//		You you = new You();
		Marry you = new You();//û�����������Ļ�ʹ�ýӿ�MarryҲ��
		
		//���������ɫ  + ��ʵ��ɫ������
		WeddingCompany company = new WeddingCompany(you);//����������������Marry�ӿ�;����youҲ������setget���������ǹ�����
		
		//ִ������
		company.marry();
		
	}
	
}


//�ӿ�
interface Marry{
	
	/*public abstract*/ void marry();
	
}

//��ʵ��ɫ
class You implements Marry{

	@Override
	public void marry() {
		System.out.println("you and her get married...");
	}
	
}

//�����ɫ
class WeddingCompany implements Marry{

	private Marry you;
	
	public WeddingCompany() {

	}
	
	public WeddingCompany(Marry you) {
		this.you = you;
	}

	private void before(){
		System.out.println("get a new house");
	}
	
	private void after(){
		System.out.println("enter the house in the evening");
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}