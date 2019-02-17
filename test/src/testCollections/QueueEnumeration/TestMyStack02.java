package testCollections.QueueEnumeration;
//测试自定义堆栈
public class TestMyStack02 {

	public static void main(String[] args) {
		MyStack<String> backHistory = new MyStack<String>(3);
		backHistory.push("www.baidu.com");
		backHistory.push("www.google.com");
		backHistory.push("www.sina.com");
		backHistory.push("www.bjsxt.com");
		//超过容量的时候是不会让加进去
		
		System.out.println(backHistory.size());
		
		//遍历
		String item = null;
		while( null != (item = backHistory.pop()) ){//pop：返回末尾的e并移除e，为空返回null
			System.out.println(item);//后进先出
		}
	}
}
