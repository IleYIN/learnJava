package testwrappedclass;

/**
 * �����Զ�װ��Ͳ���
 * @author yinyiliang
 *
 */
public class Test02 {
	public static void main(String[] args) {
//		Integer a = new Integer(1000);
		Integer a = 1000; //jdk5.0֮���Զ�װ�䣬�������Ľ�����
		Integer b = null;
		
		int c = new Integer(1500); //�������Ľ���new Integer(1500).intValue();
//		int d = b; //�������Ľ���b.intValue();
		int e = a;
//		System.out.println(d); //�ᱨ��
		System.out.println(a); 
		
		Integer f = 1234;
		Integer f2 = 1234;
		
		System.out.println(f == f2); //����ͬһ������
		System.out.println(f.equals(f2));//ֵ����ȵ�
		
		System.out.println("#################");
		Integer d3 = -129;
		Integer d4 = -129; //[-128,127]֮���������Ȼ�ᵱ�������������������������Ч�ʶ����Ƕ��󣬴�ʱ����Ϊ�������
		System.out.println(d3==d4);
		System.out.println(d3.equals(d4));
				
		
		
	}

}
