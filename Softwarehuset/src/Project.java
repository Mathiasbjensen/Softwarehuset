import java.util.ArrayList;
import java.util.List;

public class Project {

	//ID should be without year.
	private String ID;
	private String projectName;
	private int expectedTime;
	private Softwarehuset sh;
	private List<Activity> Activities = new ArrayList<Activity>();
	
	
	public Project(String projectName, int expectedTime, Softwarehuset softwarehuset) {
		
		this.sh = softwarehuset;
		int year = softwarehuset.dateserver.getYear();
		this.ID = year+""+sh.getRunningNumber();
		this.expectedTime = expectedTime;
		this.projectName = projectName;
		
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void assignProjectLeader(Employee employee, int week) throws OperationNotAllowedException {
		try {
			if(sh.getFreeEmployees(week).contains(employee)) {
				
			ProjectLeader projectLeader = new ProjectLeader(employee, this);
			sh.getFreeEmployees(week).remove(employee);
			
			}
			else {
				throw new OperationNotAllowedException("The employee is not available", "Assign project leader");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// CONSIDER GIVING ACTIVITY A NAME???????
	public void addActivity(int budgetTime, int start, int end) {
		Activity activity = new Activity(budgetTime, start, end);
		Activities.add(activity);
	}
	

	
	

}
