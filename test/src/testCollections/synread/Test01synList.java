package testCollections.synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections管理同步容器
 * 
 * @author yinyiliang
 *
 */
public class Test01synList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		//list可以同步
		List<String> synList = Collections.synchronizedList(list);
		System.out.println("线程安全的list制作完毕");
	}
}
