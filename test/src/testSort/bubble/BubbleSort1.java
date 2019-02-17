package testSort.bubble;
//初级版
import java.util.Arrays;



public class BubbleSort1 {

	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 5};
		sort(arr);
	}
	
	
	public static void sort(int[] arr){
		int len = arr.length;
		for(int j=0; j<len-1;j++){//需要换多少趟
			System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<len-1-j;i++){
				System.out.println("第"+(i+1)+"次");
				System.out.println(arr[i]+"与"+arr[i+1]+"比较");
				if (arr[i]>arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	
	
	public static void sortFirst(int[] arr) {
		//一趟
		//逻辑：从头开始相邻两个数比较并换位
		for(int i=0; i<arr.length-1;i++){
			System.out.println("第"+(i+1)+"次");
			if (arr[i]>arr[i+1]){
				int temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		
	}
}
