package testSort.innerType;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		String[] arr = {"a","abcd","abc","def"};
		//�Ӵ�С����
		sortFinal(arr);
	}

	public static void sortFinal(String[] arr){
		
		boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//��Ҫ��������
			sorted = true; //������һ���������
//		System.out.println("��"+(j+1)+"��");
			for(int i=0; i<len-1;i++){
//			System.out.println("��"+(i+1)+"��");
//			System.out.println(arr[i]+"��"+arr[i+1]+"�Ƚ�");
				if (((Comparable)arr[i]).compareTo(arr[i+1])<0){//�ӿڷ�ʽ�Ƚϴ�С
					String temp = arr[i+1];
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
