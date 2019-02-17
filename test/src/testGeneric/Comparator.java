package testGeneric;

/**
 * 泛型接口 接口里只有全局常量static和抽象方法
 * 故泛型字母不能使用在全局常量只能使用在方法中
 * @author yinyiliang
 *
 */
public class Comparator<T>{//接口
	//公共的全局常量
	/*public static final*/ int MAX_VALUE = 1024;
	
	//公共的抽象方法
	/*public abstract void*/ T compare(T t) {
		return t;
	}

}
