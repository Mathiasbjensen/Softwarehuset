import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Employee {
	private String ID;
	private String Name, dayChange;
	private int week, hoursChanged;
	private Softwarehuset sh;
	private int day = sh.dateserver.getDay();
	private ArrayList[] weekCalendar = new ArrayList[52];
	
	
	public Employee(String ID, Softwarehuset softwarehuset) {
		this.sh = softwarehuset;
		this.ID = ID;
	
		for(int i = 0; i < weekCalendar.length; i++) {
			weekCalendar[i] = new ArrayList<Activity>();
		}
	}

	// Har vi brug for denne metode????
	// -- Test af merge --
	// måske
	public String getName() {
		return Name;
		
		
	}
	// Returner intialier p� User 
	public String GetID(){ 
		return ID;
	}
	
	public void addAssignedActivity(Activity activity) throws Exception{
	
		//Checking if the employee has enough weeks available to be assigned to the project.
		for(int i = activity.getStart(); i <= activity.getEnd(); i++) {
		if(weekCalendar[i].contains(activity) ) {
			throw new OperationNotAllowedException("Employee already assigned to that activity", "add Assigned Activity");
		}
		else if(weekCalendar[i].size() > 20) {
			throw new OperationNotAllowedException("The employee is already assigned to 20 other activities in week: "+i,"add Assigned Activity");
		}
		}
		
		// Adding the activity to the week calendar.
		for(int i = activity.getStart(); i <= activity.getEnd(); i++) {
		weekCalendar[i].add(activity);
		}
		
		
	}
	public int getActivityForWeek(int week) {
		return weekCalendar[week].size();
	}
	
	public void setWorkHours(Activity activity, int hours) {
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
	
	public int getWorkHours(){
		return hoursChanged;
	}


}