import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String ID;
	private String Name;
	private List<Activity> assignedActivity = new ArrayList<Activity>();
	
	
	
	public Employee(String ID) {
		this.ID = ID;
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
	
	public void addAssignedActivity(Activity activity) {
		assignedActivity.add(activity);
		
		
	}
	
	public List<Activity> getAssignedActivity() {
		return assignedActivity;
	}


}