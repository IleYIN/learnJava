package testSort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsTest {

	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("视频1",100,2000));
		list.add(new Goods("视频2",200,2000));
		list.add(new Goods("视频3",30,1000));
		
		System.out.println("排序前：");
		Collections.sort(list, new GoodsPriceComp());
//		Collections.sort(list, new GoodsFavComp());
		System.out.println("排序后："+list);
	}
}
