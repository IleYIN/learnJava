package testCollections.QueueEnumeration;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ʹ�ö���ʵ���Զ����ջ LIFO
 * ��
 * ѹ
 * ��ȡͷ
 * 
 * 
 * Java��Queue��һЩ���÷���
 * 
 * add         ����һ��Ԫ��                      ����������������׳�һ��IIIegaISlabEepeplian�쳣
 * remove   �Ƴ������ض���ͷ����Ԫ��     �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
 * element  ���ض���ͷ����Ԫ��              �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
 * offer       ���һ��Ԫ�ز�����true        ��������������򷵻�false
 * poll         �Ƴ������ʶ���ͷ����Ԫ��     �������Ϊ�գ��򷵻�null
 * peek       ���ض���ͷ����Ԫ��              �������Ϊ�գ��򷵻�null
 * put         ���һ��Ԫ��                       �����������������
 * take        �Ƴ������ض���ͷ����Ԫ��    
 * 
 * 
 * 
 * 
 * 
 * Deque�ӿ�˫�˶��У����Ե���ջ�Ͷ�����ʹ�á� ������ʵ����linkedlist ��
 * ���Ԫ�ء�ɾ��Ԫ�أ�����ջʹ�ã�push��� popɾ��
 * 				��������ʹ�ã�offer��� pollɾ��
 * 
 * @author yinyiliang
 *
 */

public class MyStack<E> {

	//����
	private Deque<E> container = new ArrayDeque<E>();
	//����
	private int cap;
	public MyStack(int cap){
		super();
		this.cap = cap;
	}
	
	//ѹջ
	public boolean push(E e){//��
		if (container.size()+1 > cap){
			return false;
		}
		return container.offerLast(e);//��ĩβ���e�ɹ�����true
	}
	//��ջ
	public E pop(){//��
		return container.pollLast();//����ĩβ��e���Ƴ�e
	}
	//��ȡ
	public E peek(){//͵��
		return container.peekLast();//��ȡĩβ�� Ϊ�շ���null
	}
	
	public int size(){
		return container.size();
		
	}
}
