package chainOfResp;

public class ViceGeneralManager extends Leader{

	public ViceGeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getLeaveDays() < 20) {
			System.out.println("employee: "+request.getEmpName()+" request for "+request.getLeaveDays()+" days, because "+request.getReason());
			System.out.println("Vice General Manager: "+this.name+" consent.");
		} else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
