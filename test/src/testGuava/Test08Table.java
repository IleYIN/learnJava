package testGuava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * 双键的Map-->Table
 * rowKey+columnKey+value
 * 学生+课程+成绩
 * 
 * 方法
 * 所有行数据：cellSet()
 * 所有rowKey数据（学生名）：rowKeySet()
 * 所有columnKey数据（课程名）：columnKeySet()
 * 所有value（成绩）：values()
 * 学生对应的课程：rowMap().get(学生)    row(学生)
 * 课程对应的学生：columnMap.get(课程)   column(课程)
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test08Table {

	public static void main(String[] args) {
		
		Table<String,String,Integer> tables = HashBasedTable.create();
		
		//测试数据
		tables.put("a", "javase", 80);
		tables.put("b", "javase", 90);
		tables.put("a", "oracle", 100);
		tables.put("c", "oracle", 95);
		
		//所有的行数据
		Set<Cell<String,String,Integer>> cells = tables.cellSet();
		
		for(Cell<String,String,Integer> temp : cells){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		


//		Iterator<Cell<String, String, Integer>>	it = cells.iterator();
//		while(it.hasNext()){
//			Cell<String, String, Integer> temp = it.next();
//			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
//		}
		
		System.out.println("------按学生查看成绩-----");
		System.out.print("学生\t");
		
		//课程列
		Set<String> cours = tables.columnKeySet();
		
		for(String t:cours){
			System.out.print(t+"\t");
		}
		
//		Iterator<String> itcours = cours.iterator();
//		while(itcours.hasNext()){
//			String t = itcours.next();
//			System.out.print(t+"\t");
//		}
		
		System.out.println();
		
		//学生列
		Set<String> stus = tables.rowKeySet();
		for(String stu:stus){
			System.out.print(stu+"\t");
			
			//对于特定学生 Map<cour,score>
			Map<String,Integer> scores = tables.row(stu);
			for(String c:cours)
			System.out.print(scores.get(c)+"\t");
			
			System.out.println();
		}
		
		
		
		System.out.println("------按课程查看成绩-----");
		System.out.print("课程\t");
		
		//学生列
		Set<String> stus2 = tables.rowKeySet();
		
		for(String t:stus2){
			System.out.print(t+"\t");
		}
		
		
		System.out.println();
		
		//课程列
		Set<String> cours2 = tables.columnKeySet();
		for(String cour:cours2){
			System.out.print(cour+"\t");
			
			//对于特定课程 Map<stu,score>
			Map<String,Integer> scores = tables.column(cour);
			for(String stu:stus2)
			System.out.print(scores.get(stu)+"\t");
			
			System.out.println();
		}
		
		
		System.out.println("--------转换key-------");
		Table<String,String,Integer> tables2 = Tables.transpose(tables);
		
		//所有的行数据
		Set<Cell<String,String,Integer>> cells2 = tables2.cellSet();

		for(Cell<String,String,Integer> temp : cells2){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
	}
}
