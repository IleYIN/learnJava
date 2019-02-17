package testIP;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 封装端口：在InetAddress基础上+端口
 * 
 * @author yinyiliang
 *
 */
public class InetSocketTest01 {

	public static void main(String[] args) throws UnknownHostException {
		
		InetSocketAddress address = new InetSocketAddress("localhost",9999);//localhost也可以写成127.0.0.1
		//或者
		address = new InetSocketAddress(InetAddress.getByName("localhost"),9999);
		
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());//返回服务器的ip
		System.out.println(addr.getHostName());//返回域名
	}
}
