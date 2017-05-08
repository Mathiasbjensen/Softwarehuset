package Program;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Employee {
	private String ID;
	private String Name, dayChange;
	private int week;
	private double hoursChanged;
	private Softwarehuset sh;
	private int day;
	private ArrayList[] weekCalendar = new ArrayList[52];


	public Employee(String ID, Softwarehuset softwarehuset) {
		this.sh = softwarehuset;
		this.day = sh.dateserver.getDay();
		this.ID = ID;

		for(int i = 0; i < weekCalendar.length; i++) {
			weekCalendar[i] = new ArrayList<Activity>();
		}
	}


	public String getName() {
		return Name;
	}
	// Returner intialier p� User 
	public String getID(){ 
		return ID;
	}

	public boolean isEmployeeFree(Activity activity) throws Exception{
		// Precondition
		assert activity != null;
		
		//Checking if the employee has enough weeks available to be assigned to the activity.
		for(int i = activity.getStart()-1; i <= activity.getEnd()-1; i++) { // 1
			if(weekCalendar[i].contains(activity) ) { // 2
				throw new OperationNotAllowedException("Employee already assigned to that activity", "add Assigned Activity");
			}
			else if(weekCalendar[i].size() >= 20) { // 3
				throw new OperationNotAllowedException("The employee is already assigned to 20 other activities in week: "+i,"add Assigned Activity");
			}
		}
		return true;
	}
	public void updateListOfActivity(Activity activity) {
		
		// Adding the activity to the week calendar.
		for(int i = activity.getStart()-1; i <= activity.getEnd()-1; i++) {
			weekCalendar[i].add(activity);
			
			// Removing the employee from being "free" if he is working on 20 activities.
			if (weekCalendar[i].size() == 20) {

				sh.removeFreeEmployee(this, i, i);
			}
		}
		


	}
	public int getActivityForWeek(int week) {
		return weekCalendar[week].size();
	}

	public void setWorkHours(Activity activity, double hours) {
		activity.setWorkHours(hours);
		// ?Day might not be needed
		dayChange = ""+day;
		hoursChanged +=hours;

	}
	//Method to see if all worked for the day has been registered
	public String missingHours(int hours) throws Exception {
		if(hoursChanged - hours == 0) {
			return "All hours for today has been registered";
		}
		else {
			throw new OperationNotAllowedException("You still need to register "+(hours-hoursChanged)+" for today","Missing hours");
		}


	}


	public double getWorkHours(){
		return hoursChanged;
	}




}