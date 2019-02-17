package testIP;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * ��װ�˿ڣ���InetAddress������+�˿�
 * 
 * @author yinyiliang
 *
 */
public class InetSocketTest01 {

	public static void main(String[] args) throws UnknownHostException {
		
		InetSocketAddress address = new InetSocketAddress("localhost",9999);//localhostҲ����д��127.0.0.1
		//����
		address = new InetSocketAddress(InetAddress.getByName("localhost"),9999);
		
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());//���ط�������ip
		System.out.println(addr.getHostName());//��������
	}
}
