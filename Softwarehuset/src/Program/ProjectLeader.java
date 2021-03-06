package Program;
//Lavet af Sebastian s164158
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
		}

	}
	public double getProjectReport(){
		double x = project.getRemainingTime();
		return x;
	}
	
	public void addEmployeeToActivity(String activity, String employee) throws OperationNotAllowedException {
		
			try {
				project.getActivityByName(activity).assignEmployee(sh.getEmployeeByID(employee));
			} catch (Exception e) {
				throw new OperationNotAllowedException(e.getMessage(), "add employee to activity");
				
			}
		} 

		
	
	public ArrayList<Employee> findFreeEmployees(int weekStart, int weekEnd) throws OperationNotAllowedException {
		ArrayList<Employee> free = new ArrayList<Employee>();	
		free = sh.getFreeEmployees(weekStart, weekEnd);
		if (free.isEmpty()) {
			throw new OperationNotAllowedException("No free employees these weeks.","Find free employees");
		}
		return free;
	}
	

	
	
	
	
	
	

}
