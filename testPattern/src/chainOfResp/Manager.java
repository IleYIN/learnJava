package chainOfResp;

public class Manager extends Leader{

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getLeaveDays() < 10) {
			System.out.println("employee: "+request.getEmpName()+" request for "+request.getLeaveDays()+" days, because "+request.getReason());
			System.out.println("Manager: "+this.name+" consent.");
		} else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
