import java.util.Calendar;

public class ProjectLeader {
	
	Project project;
	Softwarehuset sh;
	public ProjectLeader(Employee employee, Softwarehuset sh, Project project) {
		this.project = project;
		
	}
	
	public void addActivity(int budgetTime, int start, int end, String activityName) {
		try {
			project.addActivity(budgetTime, start, end, activityName);
		} catch (OperationNotAllowedException e) {
		}
	}
	
	public void addEmployeeToActivity(String activity, String employee) {
		project.getActivityByName(activity).assignEmployee(sh.getEmployeeByID(employee));
		
	}
	

	
	
	
	
	
	

}
