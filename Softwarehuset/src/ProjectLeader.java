import java.util.Calendar;

public class ProjectLeader {
	
	Project project;
	public ProjectLeader(Employee employee, Project project) {
		this.project = project;
		
	}
	
	public void addActivity(int budgetTime, int start, int end, String activityName) {
		try {
			project.addActivity(budgetTime, start, end, activityName);
		} catch (OperationNotAllowedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double getProjectReport(){
		return project.getRemainingTime();
	}
	
	
	
	
	
	
	

}
