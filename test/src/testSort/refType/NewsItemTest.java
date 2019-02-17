package testSort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import testSort.innerType.UtilsCollections;

/**
 * 使用Collections
 * @author yinyiliang
 *
 */
public class NewsItemTest {

	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("新闻50万1小时前",50,new Date(System.currentTimeMillis()-1000*60*60)));
		news.add(new NewsItem("新闻100万",100,new Date()));
		news.add(new NewsItem("新闻60万1小时前",100,new Date(System.currentTimeMillis()-1000*60*60)));
		
		System.out.println("排序前: "+news);
		
		//排序
		Collections.sort(news);//Collections原来默认是升序
//		UtilsCollections.sort(news); 这个要注意原来是升序还是降序要改
		System.out.println("排序后: "+news);
	}
}
