package Program;
//Lavet af Mathias Bo Jensen s164159
import java.util.ArrayList;
import java.util.List;

public class Activity {
	
	private int budgetTime;
	private int start, end;
	private double totalHours;
	private String activityName;
	private List<Employee> activityEmployees = new ArrayList<Employee>();
	private Project project;
	private Softwarehuset sh;
	
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
	
	public void assignEmployee(Employee employee) throws OperationNotAllowedException{

		if(!activityEmployees.contains(employee)) {
		activityEmployees.add(employee);
		employee.updateListOfActivity(this);
		}
		
		else if (activityEmployees.contains(employee)){
			throw new OperationNotAllowedException("Employee is already working on this activity", "assign employee to activity");
		}
		
	}
	public String[] getAssignedEmployees() {
		String[] nameOfEmployees = new String[activityEmployees.size()];
		for (int i = 0; i < activityEmployees.size(); i++) {
			nameOfEmployees[i] = (activityEmployees.get(i).getID());
		}
		return nameOfEmployees;
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
	
}
