package testSort.bubble;
//��������
import java.util.Arrays;

public class BubbleSort2 {

	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 5};
		sort(arr);
	}
	
	
	public static void sort(int[] arr){
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
