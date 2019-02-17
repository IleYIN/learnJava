package testSort.refType;
//业务类 解耦 与实体类分离
public class GoodsFavComp implements java.util.Comparator<Goods>{

	@Override
	public int compare(Goods o1, Goods o2) {
//		return o1.getFav()-o2.getFav()>0?1:o1.getFav()==o2.getFav()?0:-1;
		return o1.getFav()-o2.getFav();
		//按收藏量升序，收藏量是int型 不需要写后面那一堆
	}
	
	
}
