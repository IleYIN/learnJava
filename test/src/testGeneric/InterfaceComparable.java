package testGeneric;

/**
 * ���ͽӿڣ��ͼ̳�ͬ�� ��Father
 * �������д�����ɸ��ඨ
 * �ӿڵ�ȫ�ֱ��������Ƿ���
 * 
 * @author yinyiliang
 *
 */
public interface InterfaceComparable<T> {
	/*public static final*/ int MAX_VALUE=100;
	/*public abstract*/void compare(T t);
}
//��������ָ����������
class Comp implements InterfaceComparable<Integer>{

	@Override
	public void compare(Integer t) {
		
	}
	
}

//����
class Comp1 implements InterfaceComparable{
//	T name;���в���
    String name2;
	@Override
	public void compare(Object t) {
		
	}
	
}
//������� ���෺��
class Comp2<T> implements InterfaceComparable{
	T name;
    String name2;
	@Override
	public void compare(Object t) {
		
	}
	
}
//���෺�ʹ��ڵ��ڸ��෺��
class Comp3<T,T1> implements InterfaceComparable<T>{
    T name;
    String name2;
	@Override
	public void compare(T t) {
		
	}
	
}
//���෺�� ������� ����