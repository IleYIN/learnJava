package testTCP.Chat.demo04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ����������
 * 
 * ��ȡ���ݣ�������
 * д�����ݣ������
 * 
 * @author yinyiliang
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		
		new Server().start();
	}
	
	//���ڴ�����Ӳ�ͬ�ͻ��˵Ĺܵ�
	private List<MyChannel> all = new ArrayList<MyChannel>();
	
	
	//�����߳�
	public void start() throws IOException{
		
		ServerSocket server = new ServerSocket(9999);
		
		while(true){
			
			Socket client = server.accept();
			
			//Mychannel�ǳ�Ա�ڲ��� ��������static����
			MyChannel channel = new MyChannel(client);//һ���ͻ��� һ���ܵ�
			
			all.add(channel);//��ÿ���ͻ��˵Ĺܵ������뵽������ͳһ����
			new Thread(channel).start();//һ����·
		}
	}
	
	
	/**
	 * һ���ͻ��� һ���ܵ�
	 * ������ ��������
	 * ����� ��������
	 * 
	 * @author yinyiliang
	 *
	 */
	private class MyChannel implements Runnable{

		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name;
		
		public MyChannel(Socket client) {//һ���ͻ��� һ���ܵ�
			
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();//��ȡ�ͻ�������
				//System.out.println(this.name);
				this.send("��ӭ����������");
				this.sendOthers("("+this.name+"����������)",true);
				
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis,dos);
				exit();
			}
		}
		
		
		private void exit(){
			
			isRunning = false;
			all.remove(this);//�Ƴ����øú����Ĺܵ�
			this.sendOthers("("+this.name+"�뿪������)",true);
		}
		
		
		
		
		/**
		 * ���ն�ȡ����
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
		 * ��������
		 * @param msg
		 */
		private void send(String msg){
			
			if(null==msg||msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(/*"����������-->"+*/msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dos);
				exit();
			}
			
		}
		
		
		/**
		 * �����йܵ����յ������ݷ��͸������ͻ���
		 */
		private void sendOthers(String msg, boolean sys){
			
			if(null==msg||msg.equals("")){
				return;
			}
			//�Ƿ�Ϊ˽��
			if(msg.startsWith("@") && msg.indexOf(":")>-1){
				//��ȡ����
				String name = msg.substring(1,msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);//��ȡ����Ϊ�������
				for(MyChannel other:all){
					if(other.name.equals(name)){
						other.send(this.name+"��������˵"+content);
					}
				}
			}else{
				
//			String msg = this.receive();//this��ָ���øú����Ĺܵ�������
				//��������
				for(MyChannel chan:all){
					if(chan == this){
						//�������ܵ�������������������Ҫ���������Լ�
						continue;
					}
					
					if (sys){//������ϵͳ��Ϣ
						chan.send("ϵͳ��Ϣ"+msg);
						
					} else{
						
						//���Լ��ܵ������ݷ��͸������ͻ��ˣ�chan�������ܵ�
						chan.send(this.name+"��������˵��"+msg);
					}
				}
			}
			
			}
		
		
		@Override
		public void run() {
			
			//�߳���
			while(isRunning){
//				send(receive());
				sendOthers(this.receive(),false);
			}
		}
		
	}
}
