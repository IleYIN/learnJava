package testTCP.Chat.demo04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据 线程
 * 
 * @author yinyiliang
 *
 */
public class Send implements Runnable {

	//控制台的输入流
	private BufferedReader console;
	//管道的输出流
	private DataOutputStream dos;
	//控制线程
	private boolean isRunning = true;
	//名称
	private String name;
	
	public Send(){
		
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client, String name){
		
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(this.name);
			
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	//从控制台接收数据
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 从控制台接收数据
	 * 发送数据
	 */
	public void send(String msg){

		if (null!=msg && !msg.equals("")){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				isRunning = false;
				CloseUtil.closeAll(dos,console);
			}
		}
	}
	
	
	@Override
	public void run() {
		//线程体
		while(isRunning){
			send(getMsgFromConsole());
		}
	}

}
