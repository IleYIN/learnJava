package testSort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsTest {

	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("��Ƶ1",100,2000));
		list.add(new Goods("��Ƶ2",200,2000));
		list.add(new Goods("��Ƶ3",30,1000));
		
		System.out.println("����ǰ��");
		Collections.sort(list, new GoodsPriceComp());
//		Collections.sort(list, new GoodsFavComp());
		System.out.println("�����"+list);
	}
}
