import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String ID;
	private String Name;
	private List<Employee> Employees = new ArrayList<Employee>();
	

	public Employee(String ID) {
		this.Name = Name;
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public String getID() {
		return ID;
	}


	public List<Employee> getEmployees() {
		
		return Employees;
	}
}