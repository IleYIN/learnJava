package testGuava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * ˫����Map-->Table
 * rowKey+columnKey+value
 * ѧ��+�γ�+�ɼ�
 * 
 * ����
 * ���������ݣ�cellSet()
 * ����rowKey���ݣ�ѧ��������rowKeySet()
 * ����columnKey���ݣ��γ�������columnKeySet()
 * ����value���ɼ�����values()
 * ѧ����Ӧ�Ŀγ̣�rowMap().get(ѧ��)    row(ѧ��)
 * �γ̶�Ӧ��ѧ����columnMap.get(�γ�)   column(�γ�)
 * 
 * 
 * @author yinyiliang
 *
 */
public class Test08Table {

	public static void main(String[] args) {
		
		Table<String,String,Integer> tables = HashBasedTable.create();
		
		//��������
		tables.put("a", "javase", 80);
		tables.put("b", "javase", 90);
		tables.put("a", "oracle", 100);
		tables.put("c", "oracle", 95);
		
		//���е�������
		Set<Cell<String,String,Integer>> cells = tables.cellSet();
		
		for(Cell<String,String,Integer> temp : cells){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		


//		Iterator<Cell<String, String, Integer>>	it = cells.iterator();
//		while(it.hasNext()){
//			Cell<String, String, Integer> temp = it.next();
//			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
//		}
		
		System.out.println("------��ѧ���鿴�ɼ�-----");
		System.out.print("ѧ��\t");
		
		//�γ���
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
		
		//ѧ����
		Set<String> stus = tables.rowKeySet();
		for(String stu:stus){
			System.out.print(stu+"\t");
			
			//�����ض�ѧ�� Map<cour,score>
			Map<String,Integer> scores = tables.row(stu);
			for(String c:cours)
			System.out.print(scores.get(c)+"\t");
			
			System.out.println();
		}
		
		
		
		System.out.println("------���γ̲鿴�ɼ�-----");
		System.out.print("�γ�\t");
		
		//ѧ����
		Set<String> stus2 = tables.rowKeySet();
		
		for(String t:stus2){
			System.out.print(t+"\t");
		}
		
		
		System.out.println();
		
		//�γ���
		Set<String> cours2 = tables.columnKeySet();
		for(String cour:cours2){
			System.out.print(cour+"\t");
			
			//�����ض��γ� Map<stu,score>
			Map<String,Integer> scores = tables.column(cour);
			for(String stu:stus2)
			System.out.print(scores.get(stu)+"\t");
			
			System.out.println();
		}
		
		
		System.out.println("--------ת��key-------");
		Table<String,String,Integer> tables2 = Tables.transpose(tables);
		
		//���е�������
		Set<Cell<String,String,Integer>> cells2 = tables2.cellSet();

		for(Cell<String,String,Integer> temp : cells2){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
	}
}
