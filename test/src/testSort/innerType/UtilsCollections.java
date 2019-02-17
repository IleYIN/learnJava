package testSort.innerType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ����
 * @author yinyiliang
 *
 */
public class UtilsCollections {
	
	public static <T> void sort(List<T> list, Comparator<T> com){
		/**
		 * List������+�Ƚ���Comparator
		 */
		//��ת������
		Object[] arr = list.toArray();
		sort(arr, com);
		//�ı������ж�Ӧ��ֵ,�����ź����ֵ�Ž�ȥ
		for (int i=0;i<arr.length;i++){
			list.set(i, (T)(arr[i]));
		}
	}
	
	
	
	/**
	 * ���齵��  + Comparator�ӿ�
	 * @param arr
	 */
	public static <T> void sort(Object[] arr, Comparator<T> com){
	boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//��Ҫ��������
			sorted = true; //������һ���������
//		System.out.println("��"+(j+1)+"��");
			for(int i=0; i<len-1;i++){
//			System.out.println("��"+(i+1)+"��");
//			System.out.println(arr[i]+"��"+arr[i+1]+"�Ƚ�");
				if (com.compare((T)arr[i], (T)arr[i+1])<0){//�ӿڷ�ʽ�Ƚϴ�С
					Object temp = arr[i+1];
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
//		System.out.println(Arrays.toString(arr));
	}
	
	
	
	
	
	/**
	 * �������� ʹ�÷��ͷ���
	 * @param arr
	 */
	public static <T extends Comparable<T>> void sort(List<T> list){
		//��ת������
		Object[] arr = list.toArray();
		sort(arr);
		//�ı������ж�Ӧ��ֵ,�����ź����ֵ�Ž�ȥ
		for (int i=0;i<arr.length;i++){
			list.set(i, (T)(arr[i]));
		}
	}
	
	
	
	
	/**
	 * ���齵�� ʹ�÷��ͷ���
	 * @param arr
	 */
	public static <T extends Comparable<T>> void sort(T[] arr){
		boolean sorted = true;

		int len = arr.length;
		for(int j=0; j<len-1;j++){//��Ҫ��������
			sorted = true; //������һ���������
			//		System.out.println("��"+(j+1)+"��");
			for(int i=0; i<len-1;i++){
				//			System.out.println("��"+(i+1)+"��");
				//			System.out.println(arr[i]+"��"+arr[i+1]+"�Ƚ�");
				if (((Comparable)arr[i]).compareTo(arr[i+1])<0){//�ӿڷ�ʽ�Ƚϴ�С
					T temp = arr[i+1];
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
//		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * ���齵��
	 * @param arr
	 */
	public static void sort(Object[] arr){

		boolean sorted = true;
		
		int len = arr.length;
		for(int j=0; j<len-1;j++){//��Ҫ��������
			sorted = true; //������һ���������
//		System.out.println("��"+(j+1)+"��");
			for(int i=0; i<len-1;i++){
//			System.out.println("��"+(i+1)+"��");
//			System.out.println(arr[i]+"��"+arr[i+1]+"�Ƚ�");
				if (((Comparable)arr[i]).compareTo(arr[i+1])<0){//�ӿڷ�ʽ�Ƚϴ�С
					Object temp = arr[i+1];
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
//		System.out.println(Arrays.toString(arr));
	}

	
}
