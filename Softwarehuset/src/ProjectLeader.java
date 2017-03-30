
public class ProjectLeader {
	
	Project project;
	public ProjectLeader(Employee employee, Project project) {
		this.project = project;
		
	}
	
	public void addActivity(int budgetTime, int start, int end) {
		project.addActivity(budgetTime, start, end);
	}
	
	
	
	
	
	

}
