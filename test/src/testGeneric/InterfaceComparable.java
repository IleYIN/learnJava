package testGeneric;

/**
 * 泛型接口：和继承同理 见Father
 * 子类的重写方法由父类定
 * 接口的全局变量不能是泛型
 * 
 * @author yinyiliang
 *
 */
public interface InterfaceComparable<T> {
	/*public static final*/ int MAX_VALUE=100;
	/*public abstract*/void compare(T t);
}
//声明子类指定具体类型
class Comp implements InterfaceComparable<Integer>{

	@Override
	public void compare(Integer t) {
		
	}
	
}

//擦除
class Comp1 implements InterfaceComparable{
//	T name;此行不行
    String name2;
	@Override
	public void compare(Object t) {
		
	}
	
}
//父类擦除 子类泛型
class Comp2<T> implements InterfaceComparable{
	T name;
    String name2;
	@Override
	public void compare(Object t) {
		
	}
	
}
//子类泛型大于等于父类泛型
class Comp3<T,T1> implements InterfaceComparable<T>{
    T name;
    String name2;
	@Override
	public void compare(T t) {
		
	}
	
}
//父类泛型 子类擦除 错误