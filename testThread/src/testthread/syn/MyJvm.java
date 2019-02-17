package testthread.syn;
/**
 * ���������ķ�ʽ
 * 
 * @author yinyiliang
 *
 */

/*
 * ����ʽ double checking-->if(null==instance)
 * 1��������˽�л��������ⲿֱ�Ӵ�������
 * 2������һ��˽�еľ�̬����
 * 3������һ������Ĺ����ľ�̬���� ���ʸñ������������û�ж��󣬴����ö���
 */
public class MyJvm {

	private static MyJvm instance;
	private MyJvm(){
		
	}
	
	public static MyJvm getInstance(){
		if(null==instance){//���Ч��
			synchronized(MyJvm.class){
				if(null==instance){//��ȫ
					instance = new MyJvm();
				}
				
			}
		}
		return instance;
	}
}



/*
 * ����ʽ
 * 1��������˽�л��������ⲿֱ�Ӵ�������
 * 2������һ��˽�еľ�̬����,ͬʱ�����ö���
 * 3������һ������Ĺ����ľ�̬���� ���ʸñ���������
 */
/**
 * �����������һ����������ļ��ض���ʼ�����������еķ���ֻ���ڱ�����ʱ�Ż����
 * @author yinyiliang
 *
 */
class MyJvm2 {

	private static MyJvm2 instance = new MyJvm2();
	private MyJvm2(){
		
	}
	
	public static MyJvm2 getInstance(){
		return instance;
	}
}
/**
 * ����ʹ��ʱ�Ż���أ����ʹ��MyJvm3��������getInstance�����Ļ����ڲ��಻�����
 * ��˼����˼���ʱ��
 * 
 * @author yinyiliang
 *
 */
class MyJvm3 {

	private static class JVMholder{//һ���ڲ�������
		
		private static MyJvm3 instance = new MyJvm3();
	}
	private MyJvm3(){
		
	}
	
	public static MyJvm3 getInstance(){
		return JVMholder.instance;
	}
}