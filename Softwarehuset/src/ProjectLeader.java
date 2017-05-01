import java.util.ArrayList;
import java.util.Calendar;

public class ProjectLeader {
	
	Project project;
	Softwarehuset sh;
	public ProjectLeader(Employee employee, Softwarehuset sh, Project project) {
		this.project = project;
		this.sh = sh;
		
	}
	
	public void addActivity(int budgetTime, int start, int end, String activityName) throws Exception {
		try {
			project.addActivity(budgetTime, start, end, activityName);
		} catch (OperationNotAllowedException e) {
			e.printStackTrace();
		}

	}
	public double getProjectReport(){
		return project.getRemainingTime();
	}
	
	public void addEmployeeToActivity(String activity, String employee) {
		
		try {
			project.getActivityByName(activity).assignEmployee(sh.getEmployeeByID(employee));
		} catch (Exception e) {
			
		}
		
	}
	public ArrayList<Employee> findFreeEmployees(int weekStart, int weekEnd) throws Exception {
		ArrayList<Employee> free = new ArrayList<Employee>();	
		free = sh.getFreeEmployees(weekStart, weekEnd);
		if (free.isEmpty()) {
			throw new OperationNotAllowedException("No free employees these weeks.","Find free employees");
		}
		return free;
	}
	

	
	
	
	
	
	

}
