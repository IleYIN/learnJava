package testCollections.QueueEnumeration;
//�����Զ����ջ
public class TestMyStack02 {

	public static void main(String[] args) {
		MyStack<String> backHistory = new MyStack<String>(3);
		backHistory.push("www.baidu.com");
		backHistory.push("www.google.com");
		backHistory.push("www.sina.com");
		backHistory.push("www.bjsxt.com");
		//����������ʱ���ǲ����üӽ�ȥ
		
		System.out.println(backHistory.size());
		
		//����
		String item = null;
		while( null != (item = backHistory.pop()) ){//pop������ĩβ��e���Ƴ�e��Ϊ�շ���null
			System.out.println(item);//����ȳ�
		}
	}
}
