package testSort.bubble;
//最优化版:考虑有序，减少趟数

import java.util.Arrays;

public class BubbleSortFinal {

	public static void main(String[] args) {
		int[] arr = {5, 6, 9, 3, 4, 7, 8};
		sort2(arr);
		
		System.out.println("-------------------");
		
		arr = new int[] {5, 6, 9, 3, 4, 7, 8};//简化声明不能少new
		sortFinal(arr);
	}
	
	
	public static void sortFinal(int[] arr){
		
		boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//需要换多少趟
			sorted = true; //假设这一趟是有序的
			System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<len-1;i++){
				System.out.println("第"+(i+1)+"次");
				System.out.println(arr[i]+"与"+arr[i+1]+"比较");
				if (arr[i]>arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					sorted = false; //假设是错的，需要继续下一趟
				}
					
				System.out.println(Arrays.toString(arr));
			}
			
			if(sorted){//表示从这一趟开始没有再需要换位置的了，所以退出即可不需要下一趟了
				System.out.println("没有比较可以退出");
				break;//减少了趟数
			}
		}
	}
	
	
	public static void sort2(int[] arr){
		int len = arr.length;
		for(int j=0; j<len-1;j++){//需要换多少趟
			System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<len-1;i++){
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
		
}
