package testGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * super:泛型的下限 >= 即父类或自身
 * 一般用于上限操作
 * 能够添加数据，不能添加父类对象
 * 规则
 *  List<Fruit>-->List<? super Apple>
 *  List<Apple>-->List<? super Apple>
 *  List<? super Fruit>-->List<? super Apple>
 *  
 *  不能存放
 *  List<? super FujiApple>-->List<? super Apple>
 * 
 * 
 * @author yinyiliang
 *
 */
public class SuperFruit {

	public static void test(List<? super Apple> list){
		//可以添加
		list.add(new Apple());
		list.add(new FujiApple());
		//不能添加父类对象
//		list.add(new Fruit());
	}
	
	public static void main(String[] args) {
		List<Apple> list1 = new ArrayList<Apple>();
		test(list1);
		
		List<Fruit> list2 = new ArrayList<Fruit>();
		test(list2);
		
		List<Object> list3 = new ArrayList<Object>();
		test(list3);
		
		List<? super Apple> list4 = new ArrayList<Apple>();
		test(list4);
		
		List<? super Fruit> list5 = new ArrayList<Object>();//Object是Fruit的父类或就是Fruit才行
		test(list5);
		
		List<? super FujiApple> list6 = new ArrayList<Object>();
//		test(list6);//不能用是因为? super FujiApple不一定是Apple的父类，用强转(List<? super Apple>)可能转不过去
		List<?> list7 = new ArrayList<Object>();
//		test(list7);//不能用是因为?相当于? extends Object不一定是Apple的父类
	}
}
