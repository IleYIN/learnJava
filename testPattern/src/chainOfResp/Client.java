package chainOfResp;

public class Client {

	public static void main(String[] args) {
		
		//we can define a list object(container) to save the relations below
		Leader a = new Director("A");
		Leader b = new Manager("B");
		Leader c = new GeneralManager("C");
		Leader b2 = new ViceGeneralManager("B2");

		//organize relations of objects
		a.setNextLeader(b);
		b.setNextLeader(b2);
		b2.setNextLeader(c);
		
		//start requests
		LeaveRequest req1 = new LeaveRequest("Tom", 30, "going home");
		a.handleRequest(req1);
	}
}
