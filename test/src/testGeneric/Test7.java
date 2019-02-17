package testGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK1.7中使用泛型
 * 
 * 调compile的版本，右键Java项目选择property找Java Compiler
 * 
 * 在使用或创建时不用指定类型，声明一次即可
 * @author yinyiliang
 *
 */
public class Test7 {

	public static void main(String[] args) {
		List<String> arrList = new ArrayList<String>();
		List<String> arrList2 = new ArrayList<>();
	}
}
