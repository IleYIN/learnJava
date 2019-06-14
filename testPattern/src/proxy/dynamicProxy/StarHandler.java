package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

	Star realStar;
	
	
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	
		Object object = null;
		
		System.out.println("before");
		
//		if(method.getName().equals("sing")) {
			System.out.println("###############");
			object = method.invoke(realStar, args);
//		}
		
		System.out.println("after");
		return object;
	}

}
