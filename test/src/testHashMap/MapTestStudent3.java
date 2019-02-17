package testHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//导入包的快捷键是Ctrl+Shift+o

/**
 * 面相对象+分拣存储 (1:N)
 * 
 * @author yinyiliang
 *
 */

public class MapTestStudent3 {

	public static void main(String[] args) {
		//考试
		List<Student> stuList = exam();
		//分析成绩
		Map<String,ClassRoom> map = count(stuList);
		//查看成绩
		view(map);  
		//整数是8421码来存储的；小数是整数部分和小数分开，小数部分是/2来存，如5.6中的0.6: 0.6*2=1.2-->1; 0.2*2=0.4-->0; 0.4*2=0.8-->0; 0.8*2=1.6-->1 存14位
		//所以5.6f!=5.6 左边是7位小数，右边是14位小数
	}
	
	/**
	 * 查看每个班的总分和平均分-->遍历map,通过key获取值
	 */
	public static void view(Map<String,ClassRoom> map){
		//获取迭代器对象
		Set<String> keys = map.keySet();
		Iterator<String> keysIt = keys.iterator();
		//先判断再获取
		while(keysIt.hasNext()){
			String no = keysIt.next();
			ClassRoom room = map.get(no);
			//查看总分 计算平均分
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+avg);
		}
	}
	
	
	
	/**
	 * 统计分析
	 * 面向对象
	 * 分拣存储
	 */
	public static Map<String,ClassRoom> count(List<Student> list){
		
		Map<String,ClassRoom> map = new HashMap<String,ClassRoom>();
		//遍历List
		for (Student stu:list){
			
			String no = stu.getNo();//班级编号
			double score = stu.getScore();
			ClassRoom valueroom = map.get(no);
		
			//查找map里是否存在该编号的班级，若不存在则创建ClassRoom
			if(null==valueroom){
				valueroom = new ClassRoom(no);
				map.put(no, valueroom);
			}
			//存在则放入学生
			valueroom.getStuList().add(stu);
			valueroom.setTotal(valueroom.getTotal()+score);//把分数相加求总分
		}
		
		return map;
		
	}
	
	
	
	
	/**
	 * 模拟考试 测试数据 到List中
	 */
	public static List<Student> exam(){
		List<Student> list = new ArrayList<Student>();
		//存放学生成绩
		list.add(new Student("老裴","a",80));
		list.add(new Student("老刘","a",80));
		list.add(new Student("老李","a",40));
		list.add(new Student("老朱","b",90));
		list.add(new Student("老张","b",80));
		
		return list;
		
	}
}
