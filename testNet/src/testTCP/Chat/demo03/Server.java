package testTCP.Chat.demo03;

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
			MyChannel channel = new MyChannel(client);
			
			all.add(channel);//���뵽������ͳһ����
			new Thread(channel).start();//һ����·
		}
	}
	
	
	/**
	 * һ���ͻ��� һ����·
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
		
		public MyChannel(Socket client) {
			
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis,dos);
				isRunning = false;
				all.remove(this);//�Ƴ����øú����Ĺܵ�
			}
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
				e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning = false;
				all.remove(this);//�Ƴ����øú����Ĺܵ�
			}
			return msg;
		}
		
		/**
		 * �����ѽ��յ�����
		 * @param msg
		 */
		private void send(String msg){
			if(null==msg||msg.equals("")){
				return;
			}
			try {
				dos.writeUTF("���յ�-->"+msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dos);
				isRunning = false;
				all.remove(this);//�Ƴ����øú����Ĺܵ�
			}
			
		}
		
		
		/**
		 * �����йܵ����յ������ݷ��͸������ͻ���
		 */
		private void sendOthers(){
			String msg = this.receive();//���øú����Ĺܵ�������
			//��������
			for(MyChannel chan:all){
				if(chan == this){
					//�������ܵ�������������������Ҫ���������Լ�
					continue;
				}
				//���Լ��ܵ������ݷ��͸������ͻ��ˣ�chan�������ܵ�
				chan.send(msg);
			}
		}
		
		
		
		
		
		
		
		@Override
		public void run() {
			
			//�߳���
			while(isRunning){
//				send(receive());
				sendOthers();
			}
		}
		
	}
}
