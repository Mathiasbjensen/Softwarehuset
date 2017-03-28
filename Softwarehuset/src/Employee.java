import java.util.ArrayList;
import java.util.List;

public class Employee {
<<<<<<< HEAD
	private String ID;
	private String Name;
	private List<Employee> Employees = new ArrayList<Employee>();
	

	public Employee(String ID) {
		this.Name = Name;
		this.ID = ID;
	}

	public String getName() {
		return Name;
=======
	private String ID; //navn (initials?)
	
	
	public User(String ID){ //employee
		this.ID = ID;
		
		
	}
	
	public String GetID(){ // Returner intialier på User 
		return ID;
	}



	public static void main(String[] args) {

>>>>>>> fcc4a03cded7729ffea13a6179650a542e3bf79a
	}

	public String getID() {
		return ID;
	}


	public List<Employee> getEmployees() {
		
		return Employees;
	}
}