package testSort.bubble;
//���Ż���:�������򣬼�������

import java.util.Arrays;

public class BubbleSortFinal {

	public static void main(String[] args) {
		int[] arr = {5, 6, 9, 3, 4, 7, 8};
		sort2(arr);
		
		System.out.println("-------------------");
		
		arr = new int[] {5, 6, 9, 3, 4, 7, 8};//������������new
		sortFinal(arr);
	}
	
	
	public static void sortFinal(int[] arr){
		
		boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//��Ҫ��������
			sorted = true; //������һ���������
			System.out.println("��"+(j+1)+"��");
			for(int i=0; i<len-1;i++){
				System.out.println("��"+(i+1)+"��");
				System.out.println(arr[i]+"��"+arr[i+1]+"�Ƚ�");
				if (arr[i]>arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					sorted = false; //�����Ǵ�ģ���Ҫ������һ��
				}
					
				System.out.println(Arrays.toString(arr));
			}
			
			if(sorted){//��ʾ����һ�˿�ʼû������Ҫ��λ�õ��ˣ������˳����ɲ���Ҫ��һ����
				System.out.println("û�бȽϿ����˳�");
				break;//����������
			}
		}
	}
	
	
	public static void sort2(int[] arr){
		int len = arr.length;
		for(int j=0; j<len-1;j++){//��Ҫ��������
			System.out.println("��"+(j+1)+"��");
			for(int i=0; i<len-1;i++){
				System.out.println("��"+(i+1)+"��");
				System.out.println(arr[i]+"��"+arr[i+1]+"�Ƚ�");
				if (arr[i]>arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
		
}
