package chainOfResp;

public class GeneralManager extends Leader{

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getLeaveDays() < 30) {
			System.out.println("employee: "+request.getEmpName()+" request for "+request.getLeaveDays()+" days, because "+request.getReason());
			System.out.println("General Manager: "+this.name+" consent.");
		} else {
			System.out.println("refuse "+request.getEmpName()+"'s request");
		}
	}

}
