
public class Project {

	//ID should be without year.
	private String ID;
	private String projectName;
	private int expectedTime;
	private Softwarehuset sh;
	
	
	
	public Project(String projectName, int expectedTime, Softwarehuset softwarehuset) {
		
		this.sh = softwarehuset;
		int year = softwarehuset.dateserver.getYear();
		this.ID = year+""+sh.getRunningNumber();
		this.expectedTime = expectedTime;
		this.projectName = projectName;

		// TODO Auto-generated constructor stub
		
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	// THROW EXCEPTIONS??????!!?!?!?!?!?!??!
	public void assignProjectLeader(Employee employee) throws OperationNotAllowedException {
		if(sh.getFreeEmployees().contains(employee)) {
			
		ProjectLeader projectLeader = new ProjectLeader(employee);
		sh.getFreeEmployees().remove(employee);
		}
		else {
			throw new OperationNotAllowedException("The employee is not available", "Assign project leader");
		}
	}
	

	
	

}
