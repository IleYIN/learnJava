package testGeneric;

/**
 * ����Ϊ������
 * �������� ������û�еĸ���ı��������ɸ������Զ������������涨����Լ��ı������������ඨ
 * ���� �������д���������ɸ�����������������ķ������������
 * 
 * ���಻�ܵ�������������������еķ��ͱ�����ڵ��ڸ��������
 * 
 * ���͵Ĳ���������Object
 * 
 * @author yinyiliang
 *
 */
public abstract class Father<T,T1>{
	T name;
	public abstract void test(T t);
	

}

/**
 * ��������ʱָ����������
 * ��������Ϊ��������
 * ����ͬ��
 */
class Child extends Father<String,Integer>{
	String t2;//����������Ϊ��������
	public void test (String t){
//		this.name-->����String
	};
}

/**
 * ����Ϊ������,������ʹ��ʱȷ�������ͱ����������ĵ���˳����Ի���
 *
 */
class Child2<T,T1,T3> extends Father<T,T1>{
	T1 t2;//����������Ϊ����
	public void test (T t){//�����Ĳ�������ȡ���ڸ���ĵ�һ������
//		this.name --> ����T
	};
}
class Child02<T1,T3> extends Father<Integer,T1>{
	T1 t2;//����������Ϊ����
	public void test (Integer t){
//		this.name --> ����Integer
		
	};
}


/**
 * ����Ϊ�����࣬���಻ָ������,���͵Ĳ�����ʹ��Object�滻
 */
class Child3<T1,T2> extends Father{
	T1 name2;//���������÷��ͣ�����ֻ��Object
	@Override
	public void test(Object t) {
//		this.name-->����Object
//		this.name2-->����T1
	}
}
/**
 * ����͸���ͬʱ����
 */

class Child4 extends Father{
	String name;
	//�����÷����ˣ�Ҫָ�����ͻ�����Object

	@Override
	public void test(Object t) {
//		this.name-->�����String
	}
}

/**
 * ��������������������ʹ�÷���;���಻�ܵ���������
class Child5 extends Father <T,T1>{

	@Override
	public void test(testGeneric.T t) {
		// TODO Auto-generated method stub
		
	}
}
 */
