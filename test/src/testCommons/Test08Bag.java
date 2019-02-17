package testCommons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * Bag包 允许重复
 * 
 * HashBag无序
 * TreeBag有序
 * 统计单词出现的次数(见testGuava-->Test05)
 * 
 * @author yinyiliang
 *
 */
public class Test08Bag {

	
	public static void main(String[] args) {
//		hashBag();
//		treeBag();
		
		//统计单词出现次数
		String str = "this is a cat and that is a mouse where is the food";
		String[] strArray = str.split(" ");
		
		Bag<String> bag = new TreeBag<String>();
		for(String temp:strArray){
			bag.add(temp);
		}
		
		System.out.println("-----统计次数-----");
		Set<String> keys = bag.uniqueSet();
		for(String letter:keys){
			System.out.println(letter+"-->"+bag.getCount(letter));
		}
	}
	
	
	public static void hashBag(){
		
		System.out.println("-----无序的包-----");
		
		Bag<String> bag = new HashBag<String>();
		bag.add("a");
		bag.add("a",5);
		bag.remove("a",2);
		bag.add("b");
		bag.add("c");
		
		Iterator<String> it = bag.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	
	
public static void treeBag(){
		
		System.out.println("-----有序的包-----");
		
		Bag<String> bag = new TreeBag<String>();
		bag.add("a");
		bag.add("a",5);
		bag.remove("a",2);
		bag.add("b");
		bag.add("c");
		
		Iterator<String> it = bag.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}
