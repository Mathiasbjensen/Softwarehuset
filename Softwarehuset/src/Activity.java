import java.util.ArrayList;
import java.util.List;

public class Activity {
	
	private int budgetTime;
	private int start, end;
	private double totalHours;
	private String activityName;
	private List<Employee> ActivityEmployees = new ArrayList<Employee>();
	private Project project;
	
	public Activity(int budgetTime, int start, int end, String activityName, Project project) {
		this.budgetTime = budgetTime;
		this.start = start;
		this.end = end;
		this.activityName = activityName;
		this.project = project;
	}
	
	public String getActivityName() {
		return activityName;
	}
	
	public void assignEmployee(Employee employee) {
		ActivityEmployees.add(employee);
		
	}
	public List<Employee> getAssignedEmployees() {
		return ActivityEmployees;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	
	public void setBudgetTime( int budgetTime) {
		this.budgetTime = budgetTime;
	}
	
	public void setStart(int start) {
		this.start = start;	
	}
	
	public void setEnd(int end) {
		this.end = end;	
	}
	
	public int getETA() {
		return budgetTime;
	}
	
	public void setWorkHours(double hours) {
		this.totalHours+=hours;
		project.changeExpectedTime(-hours);
		
	}
	
	public double getWorkHours() {
		return totalHours;
	}
	
	// Til test
	public void main(String[] args) {
		Activity hans = new Activity(200, 1,2,"hans", project);
		Activity skod = new Activity(300,2,3,"grete", project);
		hans.setBudgetTime(2);
		System.out.println(hans.getETA());
	}
}
