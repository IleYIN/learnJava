package testSort.innerType;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		String[] arr = {"a","abcd","abc","def"};
		//从大到小排序
		sortFinal(arr);
	}

	public static void sortFinal(String[] arr){
		
		boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//需要换多少趟
			sorted = true; //假设这一趟是有序的
//		System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<len-1;i++){
//			System.out.println("第"+(i+1)+"次");
//			System.out.println(arr[i]+"与"+arr[i+1]+"比较");
				if (((Comparable)arr[i]).compareTo(arr[i+1])<0){//接口方式比较大小
					String temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					sorted = false; //假设是错的，需要继续下一趟
				}
				
//			System.out.println(Arrays.toString(arr));
			}
			
			if(sorted){//表示从这一趟开始没有再需要换位置的了，所以退出即可不需要下一趟了
//			System.out.println("没有比较可以退出");
				break;//减少了趟数
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
