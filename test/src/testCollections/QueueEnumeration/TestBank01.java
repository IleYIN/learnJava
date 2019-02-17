package testCollections.QueueEnumeration;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ʹ�ö���ģ�����д��ҵ��
 * �Ƚ��ȳ�
 * 
 * @author yinyiliang
 *
 */
public class TestBank01 {

	public static void main(String[] args) {
		Queue<Request> que = new ArrayDeque<Request>();
		//ArrayDeque��Queue��һ��ʵ����
		//ģ���Ŷ����
		for(int i=0; i<10; i++){
			final int num = i;
			que.offer(
					new Request(){
						//�����ڲ������ֻ�ܷ���final���ε�
						
						@Override
						public void deposit() {
							System.out.println("��"+num+"���ˣ�������ҵ�񣬴����Ϊ��"+Math.random()*10000);
						}
						
					}
			);
		}
		dealWith(que);
	}
	
	//����ҵ��
	public static void dealWith(Queue<Request> que){
		Request req = null;
		while(null!=(req=que.poll())){//poll:�Ƴ������ʶ���ͷ����Ԫ��   
			req.deposit();//ͷһ���˲��ǿգ����Ƴ�����˲��Ұ��Ǯҵ��
		}
	}
}

interface Request{
	//���ҵ��
	void deposit();
}