package testHashMap;

import java.util.ArrayList;
import java.util.List;
/**
 * 一个班级 多个学生（学生列表）
 * @author yinyiliang
 *
 */

public class ClassRoom {
	
	private String no;//班级
	private List<Student> stuList;//班级学生列表
	private double total;//总分
	
	public ClassRoom() {
		stuList =  new ArrayList<Student>();// 避免空指针异常
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
