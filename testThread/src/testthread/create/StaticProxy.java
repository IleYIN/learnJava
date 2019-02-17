package testthread.create;
/**
 * 静态代理 设计模式
 * 
 * 真实角色
 * 代理角色 持有真实角色的引用
 * 二者 实现相同的接口
 * 
 * @author yinyiliang
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		
		//创建真实角色
//		You you = new You();
		Marry you = new You();//没有新增方法的话使用接口Marry也可
		
		//创建代理角色  + 真实角色的引用
		WeddingCompany company = new WeddingCompany(you);//有新增方法不能用Marry接口;传递you也可以用setget方法而不是构造器
		
		//执行任务
		company.marry();
		
	}
	
}


//接口
interface Marry{
	
	/*public abstract*/ void marry();
	
}

//真实角色
class You implements Marry{

	@Override
	public void marry() {
		System.out.println("you and her get married...");
	}
	
}

//代理角色
class WeddingCompany implements Marry{

	private Marry you;
	
	public WeddingCompany() {

	}
	
	public WeddingCompany(Marry you) {
		this.you = you;
	}

	private void before(){
		System.out.println("get a new house");
	}
	
	private void after(){
		System.out.println("enter the house in the evening");
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}