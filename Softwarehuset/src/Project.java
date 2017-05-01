import java.util.ArrayList;
import java.util.List;

public class Project {

	//ID should be without year.
	private String ID;
	private String projectName;
	private double expectedTime;
	private Softwarehuset sh;
	private List<Activity> activities = new ArrayList<Activity>();
	// Stupid to have an array for ONE projectleader??
	private ProjectLeader projectleader;
	
	
	public Project(String projectName, double expectedTime, Softwarehuset softwarehuset) {
		
		this.sh = softwarehuset;
		int year = softwarehuset.dateserver.getYear();
		this.ID = year+""+sh.getRunningNumber();
		this.expectedTime = expectedTime;
		this.projectName = projectName;
		
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	// Assigns an employee to a project leader
	public void assignProjectLeader(String employeeID) throws OperationNotAllowedException {
		
		try {
			Employee employee = sh.getEmployeeByID(employeeID);
			if(sh.getEmployees().contains(employee)) {

			ProjectLeader projectLeader = new ProjectLeader(employee, sh, this);
			this.projectleader = projectLeader;

			
			}
			else {
				throw new OperationNotAllowedException("That employee does not exist", "Assign project leader");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ProjectLeader getProjectLeader() {
		return projectleader;
	}
	

	
	// CONSIDER GIVING ACTIVITY A NAME???????


	public void addActivity(int budgetTime, int start, int end, String activityName) throws OperationNotAllowedException {
		Activity activity = new Activity(budgetTime, start, end, activityName, this);
		if (!activities.contains(activity)) {
		activities.add(activity);
	}
		else if (!activities.contains(activity)) { 
			throw new OperationNotAllowedException("That activity name is already taken.", "Add activity.");
		}
		else if ((start > 0 && start < 53) || (end > 0 && end < 53)) {
			throw new OperationNotAllowedException("The start and end weeks have to be between 1 and 52.", "add activity");
		}
		else if (budgetTime < 0) {
			throw new OperationNotAllowedException("BudgetTime has to be positive","add activity");
		}
		
		
	}
	
	public Activity getActivityByName(String activityName) throws Exception{
		
		for (int i = 0; i < activities.size();i++) {
	        if(activities.get(i).getActivityName().equals(activityName)) {
	            return activities.get(i);
	        } 
	        
		}
		throw new OperationNotAllowedException("No activity with that name", "Get activity by name");


		}
	public void changeExpectedTime(double i) {
		this.expectedTime = expectedTime + i;
	}
	public double getRemainingTime() {
		int remainingtime = 0;
		for (int i = 0; i < activities.size();i++) {
			expectedTime = expectedTime + activities.get(i).getETA();
		}
		return remainingtime;
	}
	

	
	

}
