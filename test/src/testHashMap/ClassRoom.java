package testHashMap;

import java.util.ArrayList;
import java.util.List;
/**
 * һ���༶ ���ѧ����ѧ���б�
 * @author yinyiliang
 *
 */

public class ClassRoom {
	
	private String no;//�༶
	private List<Student> stuList;//�༶ѧ���б�
	private double total;//�ܷ�
	
	public ClassRoom() {
		stuList =  new ArrayList<Student>();// �����ָ���쳣
	}
	
	public ClassRoom(String no) {
		this();
		this.no = no;
//		stuList =  new ArrayList<Student>();
	}

	public String getNo() {
		return no;
	}

	
	public ClassRoom(String no, List<Student> stuList, double total) {
		super();
		this.no = no;
		this.stuList = stuList;
		this.total = total;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStulist(List<Student> stuList) {
		this.stuList = stuList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
