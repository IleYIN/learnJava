package testSort.innerType;

import java.util.Arrays;
import java.util.Date;

public class Test03 {

	public static void main(String[] args) {
		Date[] arr = new Date[3];
		arr[0] = new Date();
		arr[1] = new Date(System.currentTimeMillis()-1000*60*60);//һ��Сʱ֮ǰ
		arr[2] = new Date(System.currentTimeMillis()+1000*60*60);//һ��Сʱ֮��
		sortFinal(arr);//����
	}
	
	public static void sortFinal(Date[] arr){
		
		boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//��Ҫ��������
			sorted = true; //������һ���������
//		System.out.println("��"+(j+1)+"��");
			for(int i=0; i<len-1;i++){
//			System.out.println("��"+(i+1)+"��");
//			System.out.println(arr[i]+"��"+arr[i+1]+"�Ƚ�");
				if (((Comparable)arr[i]).compareTo(arr[i+1])<0){//�ӿڷ�ʽ�Ƚϴ�С
					Date temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					sorted = false; //�����Ǵ�ģ���Ҫ������һ��
				}
				
//			System.out.println(Arrays.toString(arr));
			}
			
			if(sorted){//��ʾ����һ�˿�ʼû������Ҫ��λ�õ��ˣ������˳����ɲ���Ҫ��һ����
//			System.out.println("û�бȽϿ����˳�");
				break;//����������
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
