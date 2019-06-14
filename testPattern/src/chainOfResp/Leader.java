package chainOfResp;

public abstract class Leader {

	protected String name;
	protected Leader nextLeader;//next obj of the chain of responsibility
	
	public Leader(String name) {
		super();
		this.name = name;
	}
	
	public Leader getNextLeader() {
		return nextLeader;
	}
	
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	
	/**
	 * method to deal with requests
	 * 
	 * @param request
	 */
	public abstract void handleRequest(LeaveRequest request);
	
}
