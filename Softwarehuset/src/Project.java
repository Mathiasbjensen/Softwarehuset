import java.util.ArrayList;
import java.util.List;

public class Project {

	//ID should be without year.
	private String ID;
	private String projectName;
	private int expectedTime;
	private Softwarehuset sh;
	private List<Activity> activities = new ArrayList<Activity>();
	// Stupid to have an array for ONE projectleader??
	private List<ProjectLeader> projectLeaders = new ArrayList<ProjectLeader>();
	
	
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
	
	// Assigns an employee to a project leader
	public void assignProjectLeader(String employeeID) throws OperationNotAllowedException {
		Employee employee = sh.getEmployeeByID(employeeID);
		try {
			if(sh.getEmployees().contains(employee)) {
				
			ProjectLeader projectLeader = new ProjectLeader(employee, this);
			projectLeaders.add(projectLeader);
			
			}
			else {
				throw new OperationNotAllowedException("That employee does not exist", "Assign project leader");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ProjectLeader> getProjectLeader() {
		return projectLeaders;
	}
	

	
	// CONSIDER GIVING ACTIVITY A NAME???????
	public void addActivity(int budgetTime, int start, int end, String activityName) throws OperationNotAllowedException {
		
		if (!activities.contains(getActivityByName(activityName))) {
		Activity activity = new Activity(budgetTime, start, end, activityName);
		activities.add(activity);
	}
		else { throw new OperationNotAllowedException("That activity name is already taken.", "Add activity.");
		
		}
		
		
	}
	
	public Activity getActivityByName(String activityName) {
		for (int i = 0; i < activities.size();i++) {
	        if(activities.get(i).getActivityName().equals(activityName)) {
	            return activities.get(i);
	        }  
		}
		return null;


		}
	

	
	

}
