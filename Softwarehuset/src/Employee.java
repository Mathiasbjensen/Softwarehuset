import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String ID;
	private String Name;
	private List<Employee> Employees = new ArrayList<Employee>();
	
	
	public Employee(String ID) {
		this.ID = ID;
	}

	// Har vi brug for denne metode????
	// -- Test af merge --
	public String getName() {
		return Name;
		
		
	}
	// Returner intialier på User 
	public String GetID(){ 
		return ID;
	}



	public List<Employee> getEmployees() {
		
		return Employees;
	}
}