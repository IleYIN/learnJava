package testSort.innerType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 排序
 * @author yinyiliang
 *
 */
public class UtilsCollections {
	
	public static <T> void sort(List<T> list, Comparator<T> com){
		/**
		 * List的排序+比较器Comparator
		 */
		//先转成数组
		Object[] arr = list.toArray();
		sort(arr, com);
		//改变容器中对应的值,把新排好序的值放进去
		for (int i=0;i<arr.length;i++){
			list.set(i, (T)(arr[i]));
		}
	}
	
	
	
	/**
	 * 数组降序  + Comparator接口
	 * @param arr
	 */
	public static <T> void sort(Object[] arr, Comparator<T> com){
	boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//需要换多少趟
			sorted = true; //假设这一趟是有序的
//		System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<len-1;i++){
//			System.out.println("第"+(i+1)+"次");
//			System.out.println(arr[i]+"与"+arr[i+1]+"比较");
				if (com.compare((T)arr[i], (T)arr[i+1])<0){//接口方式比较大小
					Object temp = arr[i+1];
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
//		System.out.println(Arrays.toString(arr));
	}
	
	
	
	
	
	/**
	 * 容器降序 使用泛型方法
	 * @param arr
	 */
	public static <T extends Comparable<T>> void sort(List<T> list){
		//先转成数组
		Object[] arr = list.toArray();
		sort(arr);
		//改变容器中对应的值,把新排好序的值放进去
		for (int i=0;i<arr.length;i++){
			list.set(i, (T)(arr[i]));
		}
	}
	
	
	
	
	/**
	 * 数组降序 使用泛型方法
	 * @param arr
	 */
	public static <T extends Comparable<T>> void sort(T[] arr){
		boolean sorted = true;

		int len = arr.length;
		for(int j=0; j<len-1;j++){//需要换多少趟
			sorted = true; //假设这一趟是有序的
			//		System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<len-1;i++){
				//			System.out.println("第"+(i+1)+"次");
				//			System.out.println(arr[i]+"与"+arr[i+1]+"比较");
				if (((Comparable)arr[i]).compareTo(arr[i+1])<0){//接口方式比较大小
					T temp = arr[i+1];
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
//		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * 数组降序
	 * @param arr
	 */
	public static void sort(Object[] arr){

		boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//需要换多少趟
			sorted = true; //假设这一趟是有序的
//		System.out.println("第"+(j+1)+"趟");
			for(int i=0; i<len-1;i++){
//			System.out.println("第"+(i+1)+"次");
//			System.out.println(arr[i]+"与"+arr[i+1]+"比较");
				if (((Comparable)arr[i]).compareTo(arr[i+1])<0){//接口方式比较大小
					Object temp = arr[i+1];
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
//		System.out.println(Arrays.toString(arr));
	}

	
}
