import java.util.ArrayList;
import java.util.List;

public class Activity {
	
	private int budgetTime;
	int totalHours, start, end;
	private List<Employee> ActivityEmployees = new ArrayList<Employee>();
	
	public Activity(int budgetTime, int start, int end) {
		this.budgetTime = budgetTime;
		this.start = start;
		this.end = end;
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
	
	public void setWorkHours(int hours) {
		this.totalHours+=hours;
	}
	
	public int getWorkHours() {
		return totalHours;
	}
	
	// Til test
	public static void main(String[] args) {
		Activity hans = new Activity(200, 1,2);
		Activity skod = new Activity(300,2,3);
		hans.setBudgetTime(2);
		System.out.println(hans.getETA());
	}
}
