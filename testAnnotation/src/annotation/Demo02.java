package annotation;

public class Demo02 {

//	@MyAnnotation01
	@MyAnnotation01(age=19,studentName="haha",id=1001,
			schools= {"������ѧ","�Ͽ���ѧ"})
	public void test() {
		
	}
	
	@MyAnnotation02(/*value=*/"aaaa")
	public void test2() {
		
	}
}
