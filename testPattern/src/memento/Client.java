package memento;

public class Client {
	public static void main(String[] args) {
		
		CareTaker taker = new CareTaker();
		Employer emp = new Employer("A", 18, 900);
		
		System.out.println("first time print object:"+emp.getEname()+"--"+emp.getAge()+"--"+emp.getSalary());
		
		taker.setMemento(emp.memento());//do one memento
		
		emp.setAge(38);
		emp.setEname("B");
		emp.setSalary(9000);
		
		System.out.println("second time print object:"+emp.getEname()+"--"+emp.getAge()+"--"+emp.getSalary());
		
		emp.recovery(taker.getMemento());
		
		System.out.println("third time print object:"+emp.getEname()+"--"+emp.getAge()+"--"+emp.getSalary());
	}
}
