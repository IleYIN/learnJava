package testSort.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * binarySearch(List<? extends Comparable<? super T>> list, T key)
 * 二分法查找需要容器有序
 * sort排序
 * reverse(List<?> list) 翻转
 * shuffle(List<?> list) 洗牌
 * swap(List<?> list, int i, int j) 交换
 * @author yinyiliang
 *
 */
public class CollectionsTest01 {

	public static void main(String[] args) {
	
		List<Integer> cards = new ArrayList<Integer>();
		//shuffle洗牌 模拟斗地主
		for (int i=0; i<=54; i++){
			cards.add(i);
		}
		//洗牌
		Collections.shuffle(cards);
		//依次发牌
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		List<Integer> last = new ArrayList<Integer>();
		//留三张底牌，每轮发三张牌
		for(int i=0;i<51;i+=3){
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		
		System.out.println("第一个人："+p1);
		System.out.println("第二个人："+p2);
		System.out.println("第三个人："+p3);
		System.out.println("底牌："+last);
	}
	
	public static void test1(){
		//反转
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.reverse(list);//反转
		System.out.println(list);
	}
}
