package annotation;

public class Demo02 {

//	@MyAnnotation01
	@MyAnnotation01(age=19,studentName="haha",id=1001,
			schools= {"北京大学","南开大学"})
	public void test() {
		
	}
	
	@MyAnnotation02(/*value=*/"aaaa")
	public void test2() {
		
	}
}
