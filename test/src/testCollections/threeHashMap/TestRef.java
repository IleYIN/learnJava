package testCollections.threeHashMap;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 引用分类：强 软 弱 虚
 * 强与弱引用
 * 
 * @author yinyiliang
 *
 */
public class TestRef {

	public static void main(String[] args) {
		
		
		String str = new String( "He's very good.");//new出来的对象在堆中，不共享
		
		//弱引用 管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		
		//断开引用
		str = null;
		
		//通知回收
		System.gc();
		System.runFinalization();//弱引用管理运行垃圾回收机制就会回收非共享对象
		System.out.println("gc运行后："+wr.get());//发现对象已经被回收
	}
	
	
	public static void testStrong(){
		
		String str = "He's very good.";//字符串常量池 共享（不能回收）
		
		//弱引用 管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		
		//断开引用
		str = null;
		
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+wr.get());//发现对象同样存在，不能回收
	}
}
