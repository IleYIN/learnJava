package testSort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import testSort.innerType.UtilsCollections;

/**
 * ʹ��Collections
 * @author yinyiliang
 *
 */
public class NewsItemTest {

	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("����50��1Сʱǰ",50,new Date(System.currentTimeMillis()-1000*60*60)));
		news.add(new NewsItem("����100��",100,new Date()));
		news.add(new NewsItem("����60��1Сʱǰ",100,new Date(System.currentTimeMillis()-1000*60*60)));
		
		System.out.println("����ǰ: "+news);
		
		//����
		Collections.sort(news);//Collectionsԭ��Ĭ��������
//		UtilsCollections.sort(news); ���Ҫע��ԭ���������ǽ���Ҫ��
		System.out.println("�����: "+news);
	}
}
