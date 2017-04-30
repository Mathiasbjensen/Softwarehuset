import java.util.Calendar;

public class ProjectLeader {
	
	Project project;
	public ProjectLeader(Employee employee, Project project) {
		this.project = project;
		
	}
	
	public void addActivity(int budgetTime, int start, int end, String activityName) {
		project.addActivity(budgetTime, start, end, activityName);
	}
	public double getProjectReport(){
		return project.getRemainingTime();
	}
	
	
	
	
	
	
	

}
