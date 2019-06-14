package chainOfResp;

public class Director extends Leader{

	public Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getLeaveDays() < 3) {
			System.out.println("employee: "+request.getEmpName()+" days, because "+request.getLeaveDays()+" because "+request.getReason());
			System.out.println("Director: "+this.name+" consent.");
		} else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
