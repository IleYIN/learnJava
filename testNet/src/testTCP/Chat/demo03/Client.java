package testTCP.Chat.demo03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端：发送+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 
 * 问题
 * 输入流与输出流在同一个线程内 彼此应该独立才行
 * 
 * @author yinyiliang
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		
		//线程   控制台输入流+发送输出流 
		new Thread(new Send(client)).start();//一条路径
		
		//线程 接收数据 输入流
		new Thread(new Receive(client)).start();
	}
}
