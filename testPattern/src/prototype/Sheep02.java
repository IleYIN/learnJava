package prototype;

import java.util.Date;
/**
 * deep copy
 * 
 * @author y.yin
 *
 */
public class Sheep02 implements Cloneable {
	private String sname;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//use directly the clone() method in object objective
		
		/**
		 * add codes below to realize deep clone
		 */
		Sheep02 s = (Sheep02) obj;
		s.birthday = (Date) this.birthday.clone(); //also clone the attributes (clone the objects)
		
		return obj;
	}

	public Sheep02(String sname, Date birthday) {
		super();
		this.sname = sname;
		this.birthday = birthday;
	}
	
	public Sheep02() {
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


}
