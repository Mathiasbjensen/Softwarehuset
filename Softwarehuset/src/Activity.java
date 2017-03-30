import java.util.ArrayList;
import java.util.List;

public class Activity {
	
	private int budgetTime;
	int totalHours;
	private List<Employee> ActivityEmployees = new ArrayList<Employee>();
	
	public Activity(int budgetTime, int start, int end) {
		this.budgetTime=budgetTime;
	}
	
	public void assignEmployee(Employee employee) {
		ActivityEmployees.add(employee);
	}
	public List<Employee> getAssignedEmployees() {
		return ActivityEmployees;
	}
	
	
	public void setETA( int budgetTime) {
		this.budgetTime = budgetTime;
	}
	
	public int getETA() {
		return budgetTime;
	}
	
	public void setWorkHours(int hours) {
		this.totalHours+=hours;
	}
	
	public int getWorkHours() {
		return this.totalHours;
	}
	
	// Til test
	public static void main(String[] args) {
		Activity hans = new Activity(200, 1,2);
		Activity skod = new Activity(300,2,3);
		hans.setETA(2);
		System.out.println(hans.getETA());
	}
}
