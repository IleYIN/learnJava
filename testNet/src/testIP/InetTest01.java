package testIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * û�з�װ�˿�
 * 
 * @author yinyiliang
 *
 */
public class InetTest01 {

	public static void main(String[] args) throws UnknownHostException {
		
		//getLocalHost��������InetAddress����
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//���ر�����ַ
		System.out.println(addr.getHostName());//����������
//		
		//���������õ�InetAddress����
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//����163��������ip
		System.out.println(addr.getHostName());//���www.163.com
		
		//����ip�õ�InetAddress����
		addr = InetAddress.getByName("163.171.130.132");
		System.out.println(addr.getHostAddress());//����163��������ip
		System.out.println(addr.getHostName());//�����ip��������DNS���Խ������򷵻����������ip�����ڻ���DNS���������򷵻�ip
	}
}
