package testGuava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 只读设置 ImmutableList
 * 
 * @author yinyiliang
 *
 */
public class Test01ImmutableList {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		//对原有的list进行包装，相当于原有List的一个视图，快照
		List<String> readList = Collections.unmodifiableList(list);
//		readList.add("d");//java.lang.UnsupportedOperationException
		
		list.add("d");//改变原有list 视图也会改变  因此readList只读设置不够安全
		
		//Guava
		//初始化List
		List<String> immutableList = ImmutableList.of("a","b","c");
		immutableList.add("d");//java.lang.UnsupportedOperationException
		//guava对只读设置 安全可靠 并且相对简单
	}
}
