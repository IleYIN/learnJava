package testGeneric;

/**
 * ���ͽӿ� �ӿ���ֻ��ȫ�ֳ���static�ͳ��󷽷�
 * �ʷ�����ĸ����ʹ����ȫ�ֳ���ֻ��ʹ���ڷ�����
 * @author yinyiliang
 *
 */
public class Comparator<T>{//�ӿ�
	//������ȫ�ֳ���
	/*public static final*/ int MAX_VALUE = 1024;
	
	//�����ĳ��󷽷�
	/*public abstract void*/ T compare(T t) {
		return t;
	}

}
