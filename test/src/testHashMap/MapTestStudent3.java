package testHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//������Ŀ�ݼ���Ctrl+Shift+o

/**
 * �������+�ּ�洢 (1:N)
 * 
 * @author yinyiliang
 *
 */

public class MapTestStudent3 {

	public static void main(String[] args) {
		//����
		List<Student> stuList = exam();
		//�����ɼ�
		Map<String,ClassRoom> map = count(stuList);
		//�鿴�ɼ�
		view(map);  
		//������8421�����洢�ģ�С�����������ֺ�С���ֿ���С��������/2���棬��5.6�е�0.6: 0.6*2=1.2-->1; 0.2*2=0.4-->0; 0.4*2=0.8-->0; 0.8*2=1.6-->1 ��14λ
		//����5.6f!=5.6 �����7λС�����ұ���14λС��
	}
	
	/**
	 * �鿴ÿ������ֺܷ�ƽ����-->����map,ͨ��key��ȡֵ
	 */
	public static void view(Map<String,ClassRoom> map){
		//��ȡ����������
		Set<String> keys = map.keySet();
		Iterator<String> keysIt = keys.iterator();
		//���ж��ٻ�ȡ
		while(keysIt.hasNext()){
			String no = keysIt.next();
			ClassRoom room = map.get(no);
			//�鿴�ܷ� ����ƽ����
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+avg);
		}
	}
	
	
	
	/**
	 * ͳ�Ʒ���
	 * �������
	 * �ּ�洢
	 */
	public static Map<String,ClassRoom> count(List<Student> list){
		
		Map<String,ClassRoom> map = new HashMap<String,ClassRoom>();
		//����List
		for (Student stu:list){
			
			String no = stu.getNo();//�༶���
			double score = stu.getScore();
			ClassRoom valueroom = map.get(no);
		
			//����map���Ƿ���ڸñ�ŵİ༶�����������򴴽�ClassRoom
			if(null==valueroom){
				valueroom = new ClassRoom(no);
				map.put(no, valueroom);
			}
			//���������ѧ��
			valueroom.getStuList().add(stu);
			valueroom.setTotal(valueroom.getTotal()+score);//�ѷ���������ܷ�
		}
		
		return map;
		
	}
	
	
	
	
	/**
	 * ģ�⿼�� �������� ��List��
	 */
	public static List<Student> exam(){
		List<Student> list = new ArrayList<Student>();
		//���ѧ���ɼ�
		list.add(new Student("����","a",80));
		list.add(new Student("����","a",80));
		list.add(new Student("����","a",40));
		list.add(new Student("����","b",90));
		list.add(new Student("����","b",80));
		
		return list;
		
	}
}
