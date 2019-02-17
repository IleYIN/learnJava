package testIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 没有封装端口
 * 
 * @author yinyiliang
 *
 */
public class InetTest01 {

	public static void main(String[] args) throws UnknownHostException {
		
		//getLocalHost方法创建InetAddress对象
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//返回本机地址
		System.out.println(addr.getHostName());//输出计算机名
//		
		//根据域名得到InetAddress对象
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//返回163服务器的ip
		System.out.println(addr.getHostName());//输出www.163.com
		
		//根据ip得到InetAddress对象
		addr = InetAddress.getByName("163.171.130.132");
		System.out.println(addr.getHostAddress());//返回163服务器的ip
		System.out.println(addr.getHostName());//如果该ip存在且有DNS可以解析，则返回域名，如果ip不存在或者DNS不给解析则返回ip
	}
}
