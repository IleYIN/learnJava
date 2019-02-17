package testTCP.Chat.demo04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * 
 * 读取数据：输入流
 * 写出数据：输出流
 * 
 * @author yinyiliang
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		
		new Server().start();
	}
	
	//用于存放连接不同客户端的管道
	private List<MyChannel> all = new ArrayList<MyChannel>();
	
	
	//启动线程
	public void start() throws IOException{
		
		ServerSocket server = new ServerSocket(9999);
		
		while(true){
			
			Socket client = server.accept();
			
			//Mychannel是成员内部类 不能用在static方法
			MyChannel channel = new MyChannel(client);//一个客户端 一条管道
			
			all.add(channel);//与每个客户端的管道都加入到容器中统一管理
			new Thread(channel).start();//一条道路
		}
	}
	
	
	/**
	 * 一个客户端 一条管道
	 * 输入流 接收数据
	 * 输出流 发送数据
	 * 
	 * @author yinyiliang
	 *
	 */
	private class MyChannel implements Runnable{

		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name;
		
		public MyChannel(Socket client) {//一个客户端 一条管道
			
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();//读取客户端名称
				//System.out.println(this.name);
				this.send("欢迎进入聊天室");
				this.sendOthers("("+this.name+"进入聊天室)",true);
				
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis,dos);
				exit();
			}
		}
		
		
		private void exit(){
			
			isRunning = false;
			all.remove(this);//移除调用该函数的管道
			this.sendOthers("("+this.name+"离开聊天室)",true);
		}
		
		
		
		
		/**
		 * 接收读取数据
		 * @return
		 */
		private String receive(){
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
//				e.printStackTrace();
				CloseUtil.closeAll(dis);
				exit();
			}
			return msg;
		}
		
		/**
		 * 发送数据
		 * @param msg
		 */
		private void send(String msg){
			
			if(null==msg||msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(/*"服务器发送-->"+*/msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dos);
				exit();
			}
			
		}
		
		
		/**
		 * 把所有管道接收到的内容发送给其他客户端
		 */
		private void sendOthers(String msg, boolean sys){
			
			if(null==msg||msg.equals("")){
				return;
			}
			//是否为私聊
			if(msg.startsWith("@") && msg.indexOf(":")>-1){
				//获取名称
				String name = msg.substring(1,msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);//获取内容为：后面的
				for(MyChannel other:all){
					if(other.name.equals(name)){
						other.send(this.name+"对你悄悄说"+content);
					}
				}
			}else{
				
//			String msg = this.receive();//this是指调用该函数的管道的内容
				//遍历容器
				for(MyChannel chan:all){
					if(chan == this){
						//如果这个管道是自身，则跳过，不需要把自身发给自己
						continue;
					}
					
					if (sys){//表明是系统信息
						chan.send("系统信息"+msg);
						
					} else{
						
						//把自己管道的内容发送给其他客户端，chan是其他管道
						chan.send(this.name+"对所有人说："+msg);
					}
				}
			}
			
			}
		
		
		@Override
		public void run() {
			
			//线程体
			while(isRunning){
//				send(receive());
				sendOthers(this.receive(),false);
			}
		}
		
	}
}
