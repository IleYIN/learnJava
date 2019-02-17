package testGeneric;

/**
 * 父类为泛型类
 * 变量属性 子类中没有的父类的变量属性由父类属性定，若子类里面定义的自己的变量属性由子类定
 * 方法 子类的重写方法类型由父类而定，子类新增的方法由子类而定
 * 
 * 子类不能单独擦除；子类的类型中的泛型必须大于等于父类的类型
 * 
 * 泛型的擦除类似于Object
 * 
 * @author yinyiliang
 *
 */
public abstract class Father<T,T1>{
	T name;
	public abstract void test(T t);
	

}

/**
 * 子类声明时指定具体类型
 * 属性类型为具体类型
 * 方法同理
 */
class Child extends Father<String,Integer>{
	String t2;//变量方法都为具体类型
	public void test (String t){
//		this.name-->父类String
	};
}

/**
 * 子类为泛型类,类型在使用时确定，类型必须包含父类的但是顺序可以互换
 *
 */
class Child2<T,T1,T3> extends Father<T,T1>{
	T1 t2;//变量方法都为泛型
	public void test (T t){//方法的参数类型取决于父类的第一个类型
//		this.name --> 父类T
	};
}
class Child02<T1,T3> extends Father<Integer,T1>{
	T1 t2;//变量方法都为泛型
	public void test (Integer t){
//		this.name --> 父类Integer
		
	};
}


/**
 * 子类为泛型类，父类不指定类型,泛型的擦除，使用Object替换
 */
class Child3<T1,T2> extends Father{
	T1 name2;//变量可以用泛型，方法只能Object
	@Override
	public void test(Object t) {
//		this.name-->父类Object
//		this.name2-->子类T1
	}
}
/**
 * 子类和父类同时擦除
 */

class Child4 extends Father{
	String name;
	//不能用泛型了，要指定类型或者用Object

	@Override
	public void test(Object t) {
//		this.name-->子类的String
	}
}

/**
 * 错误的是子类擦除，父类使用泛型;子类不能单独擦除！
class Child5 extends Father <T,T1>{

	@Override
	public void test(testGeneric.T t) {
		// TODO Auto-generated method stub
		
	}
}
 */
